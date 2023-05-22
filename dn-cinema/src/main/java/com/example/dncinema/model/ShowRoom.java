package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "show_room")
public class ShowRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show_room")
    private Integer idShowRoom;
    @Column(name = "name_show_room", columnDefinition = "varchar(45)")
    private String nameShowRoom;
    @Column(name = "quantity_chair")
    private Integer quantityChair;

    public ShowRoom() {
    }

    public ShowRoom(Integer idShowRoom, String nameShowRoom, Integer quantityChair) {
        this.idShowRoom = idShowRoom;
        this.nameShowRoom = nameShowRoom;
        this.quantityChair = quantityChair;
    }

    public Integer getIdShowRoom() {
        return idShowRoom;
    }

    public void setIdShowRoom(Integer idShowRoom) {
        this.idShowRoom = idShowRoom;
    }

    public String getNameShowRoom() {
        return nameShowRoom;
    }

    public void setNameShowRoom(String nameShowRoom) {
        this.nameShowRoom = nameShowRoom;
    }

    public Integer getQuantityChair() {
        return quantityChair;
    }

    public void setQuantityChair(Integer quantityChair) {
        this.quantityChair = quantityChair;
    }
}
