package com.example.dncinema.repository.show_room;

import com.example.dncinema.model.Seat;
import com.example.dncinema.model.ShowRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISeatRepository extends JpaRepository<Seat,Integer> {

}
