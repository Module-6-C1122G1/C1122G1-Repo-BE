package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.ShowTime;
import com.example.dncinema.model.TypeFilm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmController_updateFilm {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateFilm_imgFilm_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm(null);
        filmDTO.setActor("Minh");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_actor_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor(null);
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    @Test
    public void updateFilm_describeFilm_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm(null);
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_director_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector(null);
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_movieLabel_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel(null);
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_nameFilm_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm(null);
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_normalSeatPrice_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(null);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_timeFilm_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(null);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_studioFilm_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm(null);
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_trailer_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer(null);
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_vipSeatPrice_13() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(null);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    @Test
    public void updateFilm_imgFilm_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("");
        filmDTO.setActor("Minh");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_actor_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_describeFilm_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_director_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_movieLabel_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_nameFilm_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_normalSeatPrice_16() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(-3.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_studioFilm_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_timeFilm_16() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(-3);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_trailer_14() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_vipSeatPrice_16() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(-3.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void updateFilm_id_99() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/film/''")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_idNull_99() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("a");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/film/null")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFilm_18() throws Exception {
        Film filmDTO = new Film();
        filmDTO.setIdFilm(1);
        filmDTO.setImgFilm("a");
        filmDTO.setActor("Minh");
        filmDTO.setDateEndFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDateStartFilm(LocalDate.parse("2023-06-10"));
        filmDTO.setDescribeFilm("a");
        filmDTO.setDirector("a");
        filmDTO.setMovieLabel("a");
        filmDTO.setNameFilm("a");
        filmDTO.setNormalSeatPrice(10.0);
        filmDTO.setStudioFilm("a");
        filmDTO.setTimeFilm(120);
        filmDTO.setTrailer("a");
        filmDTO.setVipSeatPrice(15.0);
        TypeFilm typeFilm = new TypeFilm();
        typeFilm.setIdTypeFilm(1);
        filmDTO.setTypeFilm(typeFilm);
        ShowTime showTime = new ShowTime();
        showTime.setIdShowTime(1);
        filmDTO.setShowTime(showTime);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/film/1")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
