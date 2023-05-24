package com.example.dncinema.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "show_time")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show_time")
    private Integer idShowTime;
    @Column(name = "show_date", columnDefinition = "date")
    private LocalDate showDate;
    @Column(name = "show_time", columnDefinition = "varchar(255)")
    private String showTime;

    @ManyToOne
    @JoinColumn(name = "id_show_room")
    private ShowRoom showRoom;

    @ManyToOne
    @JoinColumn(name = "id_seat")
    private Seat seat;
}
