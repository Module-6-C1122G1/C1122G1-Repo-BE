package com.example.dncinema.repository;

import com.example.dncinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISeatRepositoryMinh extends JpaRepository<Seat,Integer> {
    @Query(value = "select * from seat where id_seat=:id",nativeQuery = true)
    Seat getByIdSeat(@Param("id") Integer id);
}
