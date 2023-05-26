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
public class StatisticsController_getAllStatisticMemberDTO {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllStatisticMemberDTO_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics/member/id"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findAllStatisticMemberDTO_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics/member"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].memberName").value("John Doe"))
                .andExpect(jsonPath("[0].totalRevenue").value(8))
                .andExpect(jsonPath("[0].totalTickets").value(1))
                .andExpect(jsonPath("[0].loyaltyPoints").value(100))
                .andExpect(jsonPath("[0].memberId").value(1));
    }
}
