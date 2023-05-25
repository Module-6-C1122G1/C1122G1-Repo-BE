package com.example.dncinema.repository;

import com.example.dncinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Film, Integer> {
    @Query(value = "select * from film \n" +
            "join type_film on film.id_type_film = type_film.id_type_film\n" +
            "where name_film like concat('%', :search, '%')", nativeQuery = true)
    Page<Film> findAllFilm(String search, Pageable pageable);

//    @Query(value = "select actor,describe_film, director, img_film, name_film, trailer, name_type_film from film where id_film = :id", nativeQuery = true)
//@Query(value = "select film.name_film,film.studio_film,film.director,film.movie_label,film.time_film,film.img_film,film.date_start_film,film.actor from film \n" +
//        "join type_film on film.id_type_film = type_film.id_type_film\n" +
//        "where film.id_film = :id ", nativeQuery = true)
    @Query(value = "select * from film " +
            "join type_film on film.id_type_film = type_film.id_type_film " +
            "join show_time st on st.id_show_time = film.id_show_time" +
            " where film.id_film = :id ", nativeQuery = true)

    Film findFilmById(@Param("id") Integer id);
}
