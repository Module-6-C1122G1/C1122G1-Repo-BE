package com.example.dncinema.repository;

import com.example.dncinema.model.Discount;
import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITicketRepositoryMinh extends JpaRepository<Ticket, Integer> {
    @Query(value = "insert into ticket(code_ticket,status_ticket,price_after_discount,date_booking,id_qr,id_discount,id_employee,id_customer,id_seat) value(ticket.codeTicket,false," +
            "ticket.priceAfterDiscount,ticket.dateBooking,ticket.idQr," +
            "ticket.discount.idDiscount,null,ticket.customer.idCustomer,ticket.seat.idSeat)", nativeQuery = true)
    void saveTicket(Ticket ticket);

    @Query(value = "select * from discount where name_discount=:name",nativeQuery = true)
    Discount findByNameDiscount(String name);

}
