package com.example.dncinema.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DetailDiscountRestController_list {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function get a news of database, Check if the ID is null
     *
     * @Author: NghiaLD
     * @Date: 25/05/2023
     */
    @Test
    public void getDetail_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/discount/detailDiscount?id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function get Detail of database, Check if the ID is ''
     *
     * @Author: NghiaLD
     * @Date: 25/05/2023
     */
    @Test
    public void getDetail_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/discount/detailDiscount?id=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function get Detail of database, Check if ID doesn't exist
     *
     * @Author: NghiaLD
     * @Date: 25/05/2023
     */
    @Test
    public void getDetail_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/discount/detailDiscount?id=99999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function get Detail of database, Successful retrieval a news
     *
     * @Author: NghiaLD
     * @Date: 25/05/2023
     */
    @Test
    public void getDetail_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/discount/detailDiscount?id=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
