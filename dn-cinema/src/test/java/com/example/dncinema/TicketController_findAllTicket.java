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
public class TicketController_findAllTicket {
    @Autowired
    private MockMvc mockMvc;

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check the return list which param = null
     */

    @Test
    public void findAllTicket_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ticket/list/null")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check the return list which param = ""
     */
    @Test
    public void findAllTicket_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ticket/list/''")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check the return list which param does not exist in the database
     */
    @Test
    public void findAllTicket_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ticket/list/7")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check the return list has size = 0 which param exist
     */
    @Test
    public void findAllTicket_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ticket/list/search=abcxyz")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check the return list has size > 0 which param exist
     */
    @Test
    public void findAllFilm_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/movie?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].nameFilm").value("Fast X"))
                .andExpect(jsonPath("content[0].director").value("TruongDr"))
                .andExpect(jsonPath("content[0].trailer").value("abc"))
                .andExpect(jsonPath("content[0].describeFilm").value("abc"))
                .andExpect(jsonPath("content[0].actor").value("Truong"))
                .andExpect(jsonPath("content[0].normalSeatPrice").value(50000))
                .andExpect(jsonPath("content[0].vipSeatPrice").value(80000))
                .andExpect(jsonPath("content[0].dateStartFilm").value("2023-05-26"))
                .andExpect(jsonPath("content[0].dateEndFilm").value("2023-05-31"))
                .andExpect(jsonPath("content[0].imgFilm").value("abc"))
                .andExpect(jsonPath("content[0].typeFilm.idTypeFilm").value(1));
    }
}
