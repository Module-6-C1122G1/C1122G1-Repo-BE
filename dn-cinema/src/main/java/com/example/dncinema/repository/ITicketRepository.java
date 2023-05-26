package com.example.dncinema.repository;

import com.example.dncinema.dto.ListTicketDTO;
import com.example.dncinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(nativeQuery = true)
    Page<ListTicketDTO> find_list_ticket(@Param("search") String search, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update ticket set is_delete = true where id_ticket = :id", nativeQuery = true)
    void cancelTicket(@Param("id") Integer id);

}
