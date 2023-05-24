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
    @Query(value = "select actor,describe_film, director, img_film, name_film, trailer, name_type_film  from film where name_film like concat('%', :search, '%')", nativeQuery = true)
    Page<Film> findAllFilm(@Param("search") String search ,Pageable pageable);

    @Query(value = "select actor,describe_film, director, img_film, name_film, trailer, name_type_film from film where id_film = :id", nativeQuery = true)
    Film findFilmById(@Param("id") Integer id);
}
