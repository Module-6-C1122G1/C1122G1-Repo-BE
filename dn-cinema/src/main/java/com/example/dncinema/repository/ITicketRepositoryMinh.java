package com.example.dncinema.repository;

import com.example.dncinema.dto.SeatDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Discount;
import com.example.dncinema.model.Seat;
import com.example.dncinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketRepositoryMinh extends JpaRepository<Ticket, Integer> {
    @Query(value = "insert into ticket(code_ticket,status_ticket,price_after_discount,date_booking,id_qr,id_discount,id_employee,id_customer,id_seat) value(ticket.codeTicket,false," +
            "ticket.priceAfterDiscount,ticket.dateBooking,ticket.idQr," +
            "ticket.discount.idDiscount,null,ticket.customer.idCustomer,ticket.seat.idSeat)", nativeQuery = true)
    void saveTicket(Ticket ticket);

    @Query(value = "select s.id_seat as idSeat, s.name_seat as nameSeat, s.id_status_seat as idStatusSeat, s.id_show_room as idShowRoom, s.id_type_seat as idTypeSeat  from seat as s where s.id_seat=:id",nativeQuery = true)
    SeatDTO getFromSeatId(Integer id);

    @Query(value = "select * from discount where name_discount=:name",nativeQuery = true)
    Discount findByNameDiscount(String name);

    @Query(value = "select * from customer where id_customer= :id",nativeQuery = true)
    List<Customer> getByIdCus(@Param("id") Integer id);
}
