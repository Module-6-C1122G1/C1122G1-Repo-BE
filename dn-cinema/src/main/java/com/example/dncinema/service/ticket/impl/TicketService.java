package com.example.dncinema.service.ticket.impl;

import com.example.dncinema.dto.CustomerDTO;
import com.example.dncinema.dto.EmployeeDTO;
import com.example.dncinema.dto.SeatDTO;
import com.example.dncinema.dto.TicketDetailDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Seat;
import com.example.dncinema.model.StatusSeat;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.repository.ISeatRepository;
import com.example.dncinema.repository.ITicketRepository;
import com.example.dncinema.repository.show_room.IStatusSeatRepository;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IStatusSeatRepository statusSeatRepository;

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param id
     * @Return new ResponseEntity<>
     * @Usage_method findById to show detail ticket
     */
    @Override
    public Ticket findTicketById(Integer id) {
        return iTicketRepository.findTicketById(id);
    }

    /**
     * @param ticketDetailDTO
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Return
     * @Usage_method use method update ticket when customers change ticket
     */
    @Override
    public void update(TicketDetailDTO ticketDetailDTO) {
        Ticket tickets = iTicketRepository.findTicketById(ticketDetailDTO.getIdTicket());
        Customer customer = customerRepository.findById(ticketDetailDTO.getCustomerDTO().getIdCustomer()).get();
        Seat seat = seatRepository.findById(ticketDetailDTO.getSeatDTO().getIdSeat()).get();
        customer.setPointCustomer(ticketDetailDTO.getCustomerDTO().getPointCustomer());
        StatusSeat statusSeat = statusSeatRepository.findById(1).get();
        seat.setSeat(statusSeat);
        seatRepository.save(seat);
        customerRepository.save(customer);
        tickets.setDelete(true);
        iTicketRepository.save(tickets);
    }

    /**
     * @return new ResponseEntity
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Usage_method use method findAll ticket
     */
    @Override
    public List<TicketDetailDTO> findAll() {
        List<Ticket> tickets = iTicketRepository.findAll();
        List<TicketDetailDTO> ticketDetailDTOS = new ArrayList<>();
        TicketDetailDTO ticketDetailDTO;
        for (Ticket ticket : tickets) {
            ticketDetailDTO = new TicketDetailDTO();
            ticketDetailDTO.setEmployeeDTO(new EmployeeDTO());
            ticketDetailDTO.setCustomerDTO(new CustomerDTO());
            ticketDetailDTO.setSeatDTO(new SeatDTO());
            BeanUtils.copyProperties(ticket.getCustomer(), ticketDetailDTO.getCustomerDTO());
            BeanUtils.copyProperties(ticket.getEmployee(), ticketDetailDTO.getEmployeeDTO());
            BeanUtils.copyProperties(ticket.getSeat(), ticketDetailDTO.getSeatDTO());
            BeanUtils.copyProperties(ticket, ticketDetailDTO);
            ticketDetailDTOS.add(ticketDetailDTO);
        }
        return ticketDetailDTOS;
    }
}
