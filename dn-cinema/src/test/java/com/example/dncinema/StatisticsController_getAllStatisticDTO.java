package com.example.dncinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StatisticsController_getAllStatisticDTO {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllStatisticDTO_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics/film/id"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAllStatisticDTO_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics/film"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("nameFilm").value("Avengers: Endgame"))
                .andExpect(jsonPath("totalTicketsSold").value(2))
                .andExpect(jsonPath("totalRevenue").value(23));
    }
}
