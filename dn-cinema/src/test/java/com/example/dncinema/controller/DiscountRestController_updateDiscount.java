package com.example.dncinema.controller;

import com.example.dncinema.dto.discount.DiscountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountRestController_updateDiscount {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void updateDiscount_name_1() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount(null);
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-10-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field nameDiscount is not blank
     * @author HoangPT
     */
    @Test
    public void updateDiscount_name_2() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-10-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field nameDiscount length is not higher than 255
     * @author HoangPT
     */
    @Test
    public void updateDiscount_name_3() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-10-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field dateStart is not null
     * @author HoangPT
     */
    @Test
    public void updateDiscount_dateStart_1() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(null);
        discountDTO.setDateEnd(LocalDate.parse("2023-10-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field dateStart format is LocalDate
     * @author HoangPT
     */
    @Test
    public void updateDiscount_dateStart_2() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023917"));
        discountDTO.setDateEnd(LocalDate.parse("2023-10-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field dateEnd is not null
     * @author HoangPT
     */
    @Test
    public void updateDiscount_dateEnd_1() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(null);
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * test the validation of field dateStart format is LocalDate
     * @author HoangPT
     */
    @Test
    public void updateDiscount_dateEnd_2() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-9-17"));
        discountDTO.setDateEnd(LocalDate.parse("20231017"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field describeDiscount is not blank
     * @author HoangPT
     */
    @Test
    public void updateDiscount_describeDiscount_1() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field describeDiscount is not null
     * @author HoangPT
     */
    @Test
    public void updateDiscount_describeDiscount_2() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount(null);
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field percentDiscount is not null
     * @author HoangPT
     */
    @Test
    public void updateDiscount_percentDiscount_1() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(null);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field percentDiscount is double type
     * @author HoangPT
     */
    @Test
    public void updateDiscount_percentDiscount_2() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(Double.valueOf("asd"));
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field percentDiscount is not higher than 100
     * @author HoangPT
     */
    @Test
    public void updateDiscount_percentDiscount_3() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(101.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of field percentDiscount is higher than 100
     * @author HoangPT
     */
    @Test
    public void updateDiscount_percentDiscount_4() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(0.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * test update discount with all valid items
     * @author HoangPT
     */
    @Test
    public void updateDiscount() throws Exception{
        DiscountDTO discountDTO=new DiscountDTO();
        discountDTO.setIdDiscount(1);
        discountDTO.setNameDiscount("Khuyến mãi");
        discountDTO.setDateStart(LocalDate.parse("2023-10-17"));
        discountDTO.setDateEnd(LocalDate.parse("2023-11-17"));
        discountDTO.setDescribeDiscount("Khuyến mãi tháng 10");
        discountDTO.setPercentDiscount(10.0);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("discount/update/1").
                        content(this.objectMapper.writeValueAsString(discountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
