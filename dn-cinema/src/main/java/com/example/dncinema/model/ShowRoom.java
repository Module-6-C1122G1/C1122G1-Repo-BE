package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "show_room")
public class ShowRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show_room")
    private Integer idShowRoom;
    @Column(name = "name_show_room", columnDefinition = "varchar(255)")
    private String nameShowRoom;

    @Column(name = "quantity_seat", columnDefinition = "int")
    private Integer quantitySeat;

    public ShowRoom() {
    }

<<<<<<< HEAD
    public ShowRoom(Integer idShowRoom) {
        this.idShowRoom = idShowRoom;
    }

    public ShowRoom(Integer idShowRoom, String nameShowRoom) {
=======
    public ShowRoom(Integer idShowRoom, String nameShowRoom, Integer quantitySeat) {
>>>>>>> 49a1c67a5c5b36af56d0d58eed6b4e4ca883eb8e
        this.idShowRoom = idShowRoom;
        this.nameShowRoom = nameShowRoom;
        this.quantitySeat = quantitySeat;
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

    public Integer getQuantitySeat() {
        return quantitySeat;
    }

    public void setQuantitySeat(Integer quantitySeat) {
        this.quantitySeat = quantitySeat;
    }
}
