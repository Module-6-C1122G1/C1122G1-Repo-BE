package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promotion")
    private Integer idPromotion;
    @Column(name = "name_promotion", columnDefinition = "varchar(45)")
    private String namePromotion;
    @Column(name = "date_start", columnDefinition = "varchar(45)")
    private String dateStart;
    @Column(name = "date_end", columnDefinition = "varchar(45)")
    private String dateEnd;
    @Column(name = "describe_promotion", columnDefinition = "varchar(45)")
    private String describePromotion;
    @Column(name = "reduction_amount")
    private Double reductionAmount;

    @ManyToOne
    @JoinColumn(name = "id_type_promotion")
    private TypePromotion typePromotion;

    public Promotion() {
    }

    public Promotion(Integer idPromotion, String namePromotion, String dateStart, String dateEnd, String describePromotion, Double reductionAmount, TypePromotion typePromotion) {
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.describePromotion = describePromotion;
        this.reductionAmount = reductionAmount;
        this.typePromotion = typePromotion;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescribePromotion() {
        return describePromotion;
    }

    public void setDescribePromotion(String describePromotion) {
        this.describePromotion = describePromotion;
    }

    public Double getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(Double reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public TypePromotion getTypePromotion() {
        return typePromotion;
    }

    public void setTypePromotion(TypePromotion typePromotion) {
        this.typePromotion = typePromotion;
    }
}
