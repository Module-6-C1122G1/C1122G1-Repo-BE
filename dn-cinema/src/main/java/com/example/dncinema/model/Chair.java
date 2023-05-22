package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "chair")
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chair")
    private Integer idChair;
    @Column(name = "name_chair", columnDefinition = "varchar(45)")
    private String nameChair;

    @ManyToOne
    @JoinColumn(name = "id_status_chair")
    private StatusChair statusChair;

    @ManyToOne
    @JoinColumn(name = "id_type_chair")
    private TypeChair typeChair;

    @ManyToOne
    @JoinColumn(name = "id_show_room")
    private ShowRoom showRoom;

    public Chair() {
    }

    public Chair(Integer idChair, String nameChair, StatusChair statusChair, TypeChair typeChair, ShowRoom showRoom) {
        this.idChair = idChair;
        this.nameChair = nameChair;
        this.statusChair = statusChair;
        this.typeChair = typeChair;
        this.showRoom = showRoom;
    }

    public Integer getIdChair() {
        return idChair;
    }

    public void setIdChair(Integer idChair) {
        this.idChair = idChair;
    }

    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }

    public StatusChair getStatusChair() {
        return statusChair;
    }

    public void setStatusChair(StatusChair statusChair) {
        this.statusChair = statusChair;
    }

    public TypeChair getTypeChair() {
        return typeChair;
    }

    public void setTypeChair(TypeChair typeChair) {
        this.typeChair = typeChair;
    }

    public ShowRoom getShowRoom() {
        return showRoom;
    }

    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }
}
