package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "status_chair")
public class StatusChair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_chair")
    private Integer idStatusChair;
    @Column(name = "name_status_chair", columnDefinition = "varchar(45)")
    private String nameStatusChair;

    public StatusChair() {
    }

    public StatusChair(Integer idStatusChair, String nameStatusChair) {
        this.idStatusChair = idStatusChair;
        this.nameStatusChair = nameStatusChair;
    }

    public Integer getIdStatusChair() {
        return idStatusChair;
    }

    public void setIdStatusChair(Integer idStatusChair) {
        this.idStatusChair = idStatusChair;
    }

    public String getNameStatusChair() {
        return nameStatusChair;
    }

    public void setNameStatusChair(String nameStatusChair) {
        this.nameStatusChair = nameStatusChair;
    }
}
