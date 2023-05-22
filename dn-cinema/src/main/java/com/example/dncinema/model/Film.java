package com.example.dncinema.model;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Integer idFilm;
    @Column(name = "name_film", columnDefinition = "varchar(45)")
    private String nameFilm;
    @Column(name = "display", columnDefinition = "varchar(45)")
    private String display;
    @Column(name = "version", columnDefinition = "varchar(45)")
    private String version;
    @Column(name = "content", columnDefinition = "varchar(45)")
    private String content;
    @Column(name = "trailer", columnDefinition = "varchar(45)")
    private String trailer;
    @Column(name = "actor", columnDefinition = "varchar(45)")
    private String actor;
    @Column(name = "calendar", columnDefinition = "varchar(45)")
    private String calendar;
    @Column(name = "premiere_date", columnDefinition = "varchar(45)")
    private String premiereDate;
    @Column(name = "end_date", columnDefinition = "varchar(45)")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "id_type_film")
    private TypeFilm typeFilm;

    public Film() {
    }

    public Film(Integer idFilm, String nameFilm, String display, String version, String content, String trailer, String actor, String calendar, String premiereDate, String endDate, TypeFilm typeFilm) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.display = display;
        this.version = version;
        this.content = content;
        this.trailer = trailer;
        this.actor = actor;
        this.calendar = calendar;
        this.premiereDate = premiereDate;
        this.endDate = endDate;
        this.typeFilm = typeFilm;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }
}
