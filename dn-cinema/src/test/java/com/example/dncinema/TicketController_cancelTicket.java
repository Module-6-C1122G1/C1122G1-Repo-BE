package com.example.dncinema;

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
public class TicketController_cancelTicket {
    @Autowired
    private MockMvc mockMvc;

    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check ticket cancellation where param = null
     */

    @Test
    public void cancelTicket_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/ticket/cancelTicket/null")).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check ticket cancellation where param = ""
     */

    @Test
    public void cancelTicket_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/ticket/cancelTicket/''")).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @throws Exception
     * @Author DatLVP
     * This method is used to check ticket cancellation where param which valid param
     */
    @Test
    public void cancelTicket_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/ticket/cancelTicket/1")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
