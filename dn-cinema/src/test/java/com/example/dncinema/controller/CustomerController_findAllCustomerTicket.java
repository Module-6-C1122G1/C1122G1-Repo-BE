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
public class CustomerController_findAllCustomerTicket {

  @Autowired
  private MockMvc mockMvc;

    @Test
    public void findAllCustomerTicket_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllCustomerTicket_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllCustomerTicket_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket/10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAllCustomerTicket_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/ticket?page=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
