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
public class CustomerRestController_getInfoCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Check getInfoStudent_1 method if length is null it will return error.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:25 26/05/2023
     */
    @Test
    public void getListCustomer_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/list/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check getInfoStudent_1 method if length is empty it will return error.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:25 26/05/2023
     */
    @Test
    public void getListCustomer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/list/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Check getInfoStudent_3 method if length is does not exist it will return error.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:25 26/05/2023
     */
    @Test
    public void getListCustomer_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/list/3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    /**
     * Check the getInfoStudent_4 method that the properties are correct.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 10:40 26/05/2023
     */

    @Test
    public void getInfoStudent_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/list/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idCustomer").value(1))
                .andExpect(jsonPath("nameCustomer").value("Nguyễn Văn Thành"))
                .andExpect(jsonPath("pointCustomer").value(5))
                .andExpect(jsonPath("gender").value("Nam"))
                .andExpect(jsonPath("phone").value("01678595396"))
                .andExpect(jsonPath("address").value("Đà Nẵng"))
                .andExpect(jsonPath("email").value("thanh@gmail.com"))
                .andExpect(jsonPath("identityCard").value("206026903"));
    }
}


