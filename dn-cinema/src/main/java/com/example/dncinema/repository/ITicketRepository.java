package com.example.dncinema.repository;

import com.example.dncinema.dto.ListTicketDTO;
import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param id
     * @Return new ResponseEntity<>
     * @Usage_method findById to show detail ticket
     */
    @Query(value = "select * from ticket where id_ticket=:id", nativeQuery = true)
    Ticket findTicketById(@Param("id") Integer id);

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param ticketDetailDTO
     * @Param bindingResult
     * @Param id
     * @Return new ResponseEntity
     * @Usage_method use method update ticket when customers change ticket
     */
    @Modifying
    @Transactional
    @Query(value = "update ticket set id_seat = :id_seat" +
            " where id_ticket=:id", nativeQuery = true)
    void updateTicket(@Param("id_seat") Integer idSeat);

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param id
     * @Return new ResponseEntity<>
     * @Usage_method  use the delete ticket method to cancel the ticket
     */
    @Modifying
    @Transactional
    @Query(value = "update ticket set is_delete = true where id_ticket = :id_ticket", nativeQuery = true)
    void cancelTicket(@Param("id_ticket") Integer id);

    @Query(nativeQuery = true)
    Page<ListTicketDTO> find_list_ticket(@Param("search") String search, Pageable pageable);

}
