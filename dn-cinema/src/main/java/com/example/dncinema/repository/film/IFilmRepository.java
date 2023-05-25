package com.example.dncinema.repository.film;

import com.example.dncinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IFilmRepository extends JpaRepository<Film,Integer> {
    @Modifying
    @Query(value = "insert into film(actor, date_end_film, date_start_film, describe_film, director, img_film, movie_label, name_film, normal_seat_price, studio_film, time_film, trailer, vip_seat_price, id_show_time, id_type_film)" +
            "values(:actor, :date_end_film, :date_start_film, :describe_film, :director, :img_film, :movie_label, :name_film, :normal_seat_price, :studio_film, :time_film, :trailer, :vip_seat_price, :id_show_time, :id_type_film);", nativeQuery = true)
    void insertFilm(@Param("actor") String actor,
                    @Param("dateEndFilm")LocalDate dateEndFilm,
                    @Param("dateStartFilm") LocalDate dateStartFilm,
                    @Param("describeFilm") String describeFilm,
                    @Param("director") String director,
                    @Param("imgFilm") String imgFilm,
                    @Param("movieLabel") String movieLabel,
                    @Param("nameFilm") String nameFilm,
                    @Param("normalSeatPrice") Double normalSeatPrice,
                    @Param("studioFilm") String studioFilm,
                    @Param("timeFilm") Integer timeFilm,
                    @Param("trailer") String trailer,
                    @Param("vipSeatPrice") Double vipSeatPrice,
                    @Param("idShowTime") Integer idShowTime,
                    @Param("idTypeFilm") Integer idTypeFilm);
    @Modifying
    @Query(value = "update film f set " +
            "f.actor = :?," +
            "f.date_end_film = :?," +
            "f.date_start_film = :?," +
            "f.describe_film = :?," +
            "f.director = :?," +
            "f.img_film = :?," +
            "f.movie_label = :?," +
            "f.name_film = :?," +
            "f.normal_seat_price = :?," +
            "f.studio_film = :?," +
            "f.time_film = :?," +
            "f.trailer = :?," +
            "f.vip_seat_price = :?," +
            "f.id_show_time = :?," +
            "f.id_type_film = :?" +
            "where f.id_film = :id_film",nativeQuery = true)
//    Film updateFilm(String actor,LocalDate dateEndFilm,LocalDate dateStartFilm,String describeFilm, String director, String imgFilm, String movieLabel, String nameFilm, Double normalSeatPrice,
//                    String studioFilm, Integer timeFilm, String trailer, Double vipSeatPrice, Integer idShowTime,Integer idTypeFilm);
    Film updateFilm(Film film);
}
