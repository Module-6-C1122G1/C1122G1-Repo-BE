package com.example.dncinema.service.impl;

import com.example.dncinema.config.Config;
import com.example.dncinema.dto.SeatDTO;
import com.example.dncinema.dto.TicketDTO;
import com.example.dncinema.model.*;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.repository.ITicketRepositoryMinh;
import com.example.dncinema.service.ITicketServiceMinh;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class
TicketServiceMinh implements ITicketServiceMinh {
    @Autowired
    private ITicketRepositoryMinh iTicketRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void saveTicket(TicketDTO ticketDTO) throws UnsupportedEncodingException {
        int a = 0;
        a++;
        String seats = "";
        for (int i = 0; i < ticketDTO.getListSeat().length; i++) {
            seats += ticketDTO.getListSeat()[i].toString()+" ";
        }
        String data = "Seat" + " "+seats;
        String path = "C:\\Users\\ADMIN\\Desktop\\du_an_be\\dn-cinema-api\\dn-cinema\\src\\main\\resources\\qr\\QR" + a + ".png";
        createQR(data, a, path);
        Ticket ticket;
        for (int i = 0; i < ticketDTO.getListSeat().length; i++) {
            SeatDTO seatDTO = iTicketRepository.getFromSeatId(ticketDTO.getListSeat()[i]);
            Seat seat = new Seat(seatDTO.getIdSeat(), seatDTO.getNameSeat(), new StatusSeat(seatDTO.getIdStatusSeat()), new TypeSeat(seatDTO.getIdTypeSeat()),
                    new ShowRoom(seatDTO.getIdShowRoom()));

            ticket = new Ticket("45", false, ticketDTO.getPrice(), LocalDate.now(), path, ticketDTO.getDiscount(), null, ticketDTO.getCustomer(), seat);

            iTicketRepository.save(ticket);
        }
        List<Customer> list = iCustomerRepository.getByIdCus(ticketDTO.getCustomer().getIdCustomer());
        pay(ticketDTO.getPrice());
        sendEmail(list.get(0).getEmail(), path);
    }

    public void createQR(String data, int a, String path) {
        try {
            Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                    = new HashMap<EncodeHintType,
                    ErrorCorrectionLevel>();

            hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(data.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8),
                    BarcodeFormat.QR_CODE, 100, 100);
            MatrixToImageWriter.writeToFile(
                    matrix,
                    path.substring(path.lastIndexOf('.') + 1),
                    new File(path));
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmail(String email, String path) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(mimeMessage, true);
            message.setTo(email);
            message.setSubject("Mã QR");
            message.setText("Kính gửi Quý khách hàng,<br><br>"
                            + "<div style=\"font-weight:bold\">Đây là mã QR của bạn:</div>"
                            + "<img src=\"cid:qr\">"
                            + "<br>"
                            + "Cảm ơn quý khách đã đặt vé xem phim của chúng tôi. "
                            + "Vui lòng không chia sẻ mã này với bất kỳ ai, "
                            + "vì nó được sử dụng để xác thực tài khoản của bạn."
                            + "<br>"
                            + "Nếu bạn không yêu cầu mã OTP, "
                            + "vui lòng bỏ qua email này hoặc liên hệ với chúng tôi để được hỗ trợ."
                            + "<br><br>"
                            + "Trân trọng,<br>"
                            + "<div style=\"color:#183661; font-size:20px; font-weight:bold\">DN Cinema</div>",
                    true);
            FileSystemResource qrImage = new FileSystemResource(new File(path));
            message.addInline("qr", qrImage);
            javaMailSender.send(message.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Discount findDiscount(String name) {
        return iTicketRepository.findByNameDiscount(name);
    }

    public String pay(long amount) throws UnsupportedEncodingException {
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TxnRef = Config.getRandomNumber(8);

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", "NCB");

        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_Locale", "vn");

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }
}
