package com.example.dncinema.model;

import com.example.dncinema.model.employee.Employee;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Column(name = "date_booking", columnDefinition = "varchar(45)")
    private String dateBooking;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_promotion")
    private Promotion promotion;

    public Ticket() {
    }

    public Ticket(Integer idTicket, String dateBooking, Double price, Employee employee, Customer customer, Promotion promotion) {
        this.idTicket = idTicket;
        this.dateBooking = dateBooking;
        this.price = price;
        this.employee = employee;
        this.customer = customer;
        this.promotion = promotion;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
