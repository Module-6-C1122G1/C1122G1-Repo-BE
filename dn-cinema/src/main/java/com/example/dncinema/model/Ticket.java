package com.example.dncinema.model;
import com.example.dncinema.dto.ListTicketDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
@NamedNativeQuery(
        name = "Ticket.find_list_ticket",
        query =
                "select ticket.id_ticket as id_ticket, ticket.is_delete as is_delete, customer.id_customer as id_customer, customer.name_customer as name_customer, customer.phone as phone, customer.identity_card as identity_card, film.name_film as name_film, show_time.show_date as show_date, show_time.show_time as show_time from ticket\n" +
                        "   join customer on ticket.id_customer = customer.id_customer\n" +
                        "   join seat on ticket.id_seat = seat.id_seat\n" +
                        "   join show_time on seat.id_seat = show_time.id_seat\n" +
                        "   join film on show_time.id_show_time = film.id_show_time\n" +
                        "   where (customer.name_customer like concat('%', :search, '%')\n" +
                        "   or customer.phone like concat('%', :search, '%')\n" +
                        "   or customer.identity_card like concat('%', :search, '%')\n" +
                        "   or film.name_film like concat('%', :search, '%'))\n" +
                        "   and ticket.is_delete = false",
        resultSetMapping = "list_ticket_dto"
)
@SqlResultSetMapping(
        name = "list_ticket_dto",
        classes = @ConstructorResult(
                targetClass = ListTicketDTO.class,
                columns = {
                        @ColumnResult(name = "id_ticket", type = Integer.class),
                        @ColumnResult(name = "id_customer", type = Integer.class),
                        @ColumnResult(name = "name_customer", type = String.class),
                        @ColumnResult(name = "phone", type = String.class),
                        @ColumnResult(name = "identity_card", type = String.class),
                        @ColumnResult(name = "name_film", type = String.class),
                        @ColumnResult(name = "show_date", type = LocalDate.class),
                        @ColumnResult(name = "show_time", type = String.class),
                        @ColumnResult(name = "is_delete", type = Boolean.class)

                }
        )
)
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ticket")
    private Integer idTicket;
    @Column(name = "status_ticket")
    private boolean statusTicket;
    @Column(name = "price_after_discount")
    private Double priceAfterDiscount;
    @Column(name = "date_booking", columnDefinition = "date")
    private LocalDate dateBooking;
    @Column(name = "id_qr")
    private String idQr;
    @Column(name = "is_delete")
    private Boolean isDelete;
    @OneToOne
    @JoinColumn(name = "id_discount")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "id_seat")
    private Seat seat;

    public Ticket() {
    }


    public Ticket( Boolean statusTicket, Double priceAfterDiscount, LocalDate dateBooking, String idQr,Boolean isDelete, Discount discount, Employee employee, Customer customer, Seat seat) {
        this.statusTicket = statusTicket;
        this.priceAfterDiscount = priceAfterDiscount;
        this.dateBooking = dateBooking;
        this.idQr = idQr;
        this.isDelete = isDelete;
        this.discount = discount;
        this.employee = employee;
        this.customer = customer;
        this.seat = seat;
    }


    public Ticket(Integer idTicket, Boolean statusTicket, Double priceAfterDiscount, LocalDate dateBooking, String idQr, Boolean isDelete, Discount discount, Employee employee, Customer customer, Seat seat) {
        this.idTicket = idTicket;
        this.statusTicket = statusTicket;
        this.priceAfterDiscount = priceAfterDiscount;
        this.dateBooking = dateBooking;
        this.idQr = idQr;
        this.isDelete = isDelete;
        this.discount = discount;
        this.employee = employee;
        this.customer = customer;
        this.seat = seat;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }


    public Boolean getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(boolean statusTicket) {
        this.statusTicket = statusTicket;
    }

    public Double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(Double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getIdQr() {
        return idQr;
    }

    public void setIdQr(String idQr) {
        this.idQr = idQr;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
