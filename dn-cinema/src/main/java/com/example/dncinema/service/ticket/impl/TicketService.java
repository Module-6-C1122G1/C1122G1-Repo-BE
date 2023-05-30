package com.example.dncinema.service.ticket.impl;

import com.example.dncinema.dto.*;
import com.example.dncinema.dto.customerDTO.CustomerDTO;
import com.example.dncinema.model.Customer;
import com.example.dncinema.model.Seat;
import com.example.dncinema.model.StatusSeat;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.repository.ICustomerRepository;
import com.example.dncinema.repository.IMovieRepository;

import com.example.dncinema.repository.ISeatRepositoryQuynh;
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
    private ISeatRepositoryQuynh seatRepository;
    @Autowired
    private IStatusSeatRepository statusSeatRepository;
    @Autowired
    private IMovieRepository iMovieRepository;

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
     * @param ticketUpdateDTO
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Return
     * @Usage_method use method update ticket when customers change ticket
     */
    @Override
    public void update(TicketUpdateDTO ticketUpdateDTO) {
        Ticket tickets = iTicketRepository.findTicketById(ticketUpdateDTO.getIdTicket());
        Customer customer = customerRepository.findById(ticketUpdateDTO.getIdCustomer()).get();
        Seat seat = seatRepository.findById(ticketUpdateDTO.getIdSeat()).get();
        customer.setPointCustomer(customer.getPointCustomer()-15);
        StatusSeat statusSeat = statusSeatRepository.findById(2).get();
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
