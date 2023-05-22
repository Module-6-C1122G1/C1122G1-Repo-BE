package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "type_chair")
public class TypeChair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_chair")
    private Integer idTypeChair;
    @Column(name = "name_type_chair", columnDefinition = "varchar(45)")
    private String nameTypeChair;

    public TypeChair() {
    }

    public TypeChair(Integer idTypeChair, String nameTypeChair) {
        this.idTypeChair = idTypeChair;
        this.nameTypeChair = nameTypeChair;
    }

    public Integer getIdTypeChair() {
        return idTypeChair;
    }

    public void setIdTypeChair(Integer idTypeChair) {
        this.idTypeChair = idTypeChair;
    }

    public String getNameTypeChair() {
        return nameTypeChair;
    }

    public void setNameTypeChair(String nameTypeChair) {
        this.nameTypeChair = nameTypeChair;
    }
}
