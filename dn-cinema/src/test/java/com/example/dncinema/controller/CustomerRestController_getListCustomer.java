package com.example.dncinema.controller;

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
public class CustomerRestController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sachs rong, tim kiem .....
     * @throws Exception
     */
    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].name").value("Nguyễn Binh An"));
    }


}
