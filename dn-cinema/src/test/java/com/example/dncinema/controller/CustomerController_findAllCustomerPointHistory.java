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
public class CustomerController_findAllCustomerPointHistory {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this method is used to check the return list which param = null
     * @author DongPV
     * @throws Exception
     */
    @Test
    public void findAllCustomerPointHistory_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/history/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is used to check the return list which param = ""
     * @author Dong PV
     * @throws Exception
     */
    @Test
    public void findAllCustomerPointHistory_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/history/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is used to check the return list which param does not exist
     * @author DongPV
     * @throws Exception
     */
    @Test
    public void findAllCustomerPointHistory_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/history/10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is used to check the return list has size > 0 which param exist
     * @author DongPV
     * @throws Exception
     */
    @Test
    public void findAllCustomerPointHistory_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/history?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].nameCustomer").value("Trường"))
                .andExpect(jsonPath("content[0].pointCustomer").value("7000.0"))
                .andExpect(jsonPath("content[0].gender").value("Nam"))
                .andExpect(jsonPath("content[0].phone").value("096452199"))
                .andExpect(jsonPath("content[0].address").value("Hải Lăng"))
                .andExpect(jsonPath("content[0].email").value("gdfgfd@gmail.com"))
                .andExpect(jsonPath("content[0].identityCard").value("646478452122"))
                .andExpect(jsonPath("content[0].typeCustomer.idTypeCustomer").value(1));
    }
}
