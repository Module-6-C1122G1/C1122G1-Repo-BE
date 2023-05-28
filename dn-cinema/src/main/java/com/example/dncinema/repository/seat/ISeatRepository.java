package com.example.dncinema.repository.seat;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.Seat;
import com.example.dncinema.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer> {
    @Query(value = "select * from seat where id_show_time = :id", nativeQuery = true)
    List<Seat> findAllListSeatByIdShowTime(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "update seat set id_status_seat = 3 where id_seat = :id", nativeQuery = true)
    void updateStatusSeatByIdShowTime(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update seat set id_status_seat = 2 where id_seat = :id", nativeQuery = true)
    void resetStatusSeatByIdShowTime(@Param("id") Integer id);


}
