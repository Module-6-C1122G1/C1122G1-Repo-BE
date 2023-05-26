package com.example.dncinema.repository.film;

import com.example.dncinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFilmRepository extends JpaRepository<Film,Integer> {
//    @Modifying
//    @Query(value = "insert into film(actor, date_end_film, date_start_film, describe_film, director, img_film, movie_label, name_film, normal_seat_price, studio_film, time_film, trailer, vip_seat_price, id_show_time, id_type_film)" +
//            "values(:actor, :date_end_film, :date_start_film, :describe_film, :director, :img_film, :movie_label, :name_film, :normal_seat_price, :studio_film, :time_film, :trailer, :vip_seat_price, :id_show_time, :id_type_film);", nativeQuery = true)
//    void insertFilm(Film film);
//    @Modifying
//    @Query(value = "update film f set " +
//            "f.actor = :?," +
//            "f.date_end_film = :?," +
//            "f.date_start_film = :?," +
//            "f.describe_film = :?," +
//            "f.director = :?," +
//            "f.img_film = :?," +
//            "f.movie_label = :?," +
//            "f.name_film = :?," +
//            "f.normal_seat_price = :?," +
//            "f.studio_film = :?," +
//            "f.time_film = :?," +
//            "f.trailer = :?," +
//            "f.vip_seat_price = :?," +
//            "f.id_show_time = :?," +
//            "f.id_type_film = :?" +
//            "where f.id_film = :id_film",nativeQuery = true)
//    void updateFilm(Film film);
//    @Modifying
//    @Query(value = "SELECT * from film f where f.id_film = id_film ", nativeQuery = true)
//    Optional<Film> findFilmByIdFilm(Integer idFilm);
    Optional<Film> findFilmByIdFilm(Integer idFilm);
}
