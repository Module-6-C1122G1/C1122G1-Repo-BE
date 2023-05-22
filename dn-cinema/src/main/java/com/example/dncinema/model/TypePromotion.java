package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "type_promotion")
public class TypePromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_promotion")
    private Integer idTypePromotion;
    @Column(name = "name_type_promotion", columnDefinition = "varchar(45)")
    private String nameTypePromotion;

    public TypePromotion() {
    }

    public TypePromotion(Integer idTypePromotion, String nameTypePromotion) {
        this.idTypePromotion = idTypePromotion;
        this.nameTypePromotion = nameTypePromotion;
    }

    public Integer getIdTypePromotion() {
        return idTypePromotion;
    }

    public void setIdTypePromotion(Integer idTypePromotion) {
        this.idTypePromotion = idTypePromotion;
    }

    public String getNameTypePromotion() {
        return nameTypePromotion;
    }

    public void setNameTypePromotion(String nameTypePromotion) {
        this.nameTypePromotion = nameTypePromotion;
    }
}
