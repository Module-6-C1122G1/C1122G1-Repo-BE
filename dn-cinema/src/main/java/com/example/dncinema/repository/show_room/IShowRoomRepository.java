package com.example.dncinema.repository.show_room;


import com.example.dncinema.model.ShowRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IShowRoomRepository extends JpaRepository<ShowRoom, Integer> {
//    @Query(value = "select name_show_room,quantity_show_room"+
//            "where name_show_room like concat('%', :name, '%') ", nativeQuery = true)
//    Page<ShowRoom> findShowRoomByName(Pageable pageable, @Param("name") String name);
//
//    @Modifying
//    @Transactional
//    @Query(value = "insert into show_room (name_show_room,quantity_seat) " +
//            "values (:name_show_room, :quantity_seat)", nativeQuery = true)
//    void addShowRoom(@Param("name") String name,
//                     @Param("quantity") Integer quantity);
//
//    @Modifying
//    @Transactional
//    @Query(value = "delete from show_room where id = :id_show_room", nativeQuery = true)
//    void deleteShowRoom(@Param("id") Integer id);
//
//    @Query(value = "select name_show_room,quantity_seat,name_seat,name_type_seat, name_status_seat from " +
//            "            \"show_room inner join seat on seat.id_show_room = show_room.id_show_room\" +\n" +
//            "            \"inner join type_seat on type_seat.id_type_seat = seat.id_type_seat\" +\n" +
//            "            \"inner join status_seat on status_seat.id_status_seat = seat.id_status_seat \"" +
//            " where id = :id_show_room", nativeQuery = true)
//    ShowRoom findShowRoomById(@Param("id") Integer id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "update show_room set  name = :name_show_room,quantity = :quantity_seat where id = :id_show_room", nativeQuery = true)
//    void updateShowRoom(@Param("name") String name,
//                        @Param("quantity") Integer quantity,
//                        @Param("id") Integer id);
}