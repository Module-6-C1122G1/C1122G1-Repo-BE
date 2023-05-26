package com.example.dncinema.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this method is to check if when calling path "/customer/list" by GET method, response from server has success status (2xx).
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:00 26/05/2023
     */
    @Test
    public void getListCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * The function of this method is to check that the return values from the path "/customer/list" when sending the GET request are correct with the expected values.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:15 26/05/2023
     */
    @Test
    public void getListCustomer_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idCustomer").value(1))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Văn Thành"))
                .andExpect(jsonPath("content[0].pointCustomer").value(5))
                .andExpect(jsonPath("content[0].gender").value("Nam"))
                .andExpect(jsonPath("content[0].phone").value("01678595396"))
                .andExpect(jsonPath("content[0].address").value("Đà Nẵng"))
                .andExpect(jsonPath("content[0].email").value("thanh@gmail.com"))
                .andExpect(jsonPath("content[0].identityCard").value("206026903"))
        ;
    }


    /**
     * The function of this method is to check that the return values from the path "/customer/list" when sending the GET request are correct with the expected values.
     * @throws Exception if an error occurs during the test.
     * @author ThanhNV
     * @Time 9:40 26/05/2023
     */
    @Test
    public void getListCustomer_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[1].idCustomer").value(2))
                .andExpect(jsonPath("content[1].nameCustomer").value("Nguyễn Thị Ngân"))
                .andExpect(jsonPath("content[1].pointCustomer").value(9))
                .andExpect(jsonPath("content[1].gender").value("Nữ"))
                .andExpect(jsonPath("content[1].phone").value("0905262352"))
                .andExpect(jsonPath("content[1].address").value("Hà Nội"))
                .andExpect(jsonPath("content[1].email").value("nganngo@gmail.com"))
                .andExpect(jsonPath("content[1].identityCard").value("202020202"))
        ;
    }
}
