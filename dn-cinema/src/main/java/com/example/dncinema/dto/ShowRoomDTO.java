package com.example.dncinema.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ShowRoomDTO {

    private Integer idShowRoom;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 10, message = "Tên phòng chiếu không dài quá 10 ký tự")
    private String nameShowRoom;


    @Positive(message = "Số lượng ghế phải là số nguyên dương")
    @Digits(fraction = 0, message = "Số lượng ghế phải là số nguyên", integer = 50)
    private Integer quantitySeat;

    public ShowRoomDTO() {
    }

    public ShowRoomDTO(Integer idShowRoom, String nameShowRoom, Integer quantitySeat) {
        this.idShowRoom = idShowRoom;
        this.nameShowRoom = nameShowRoom;
        this.quantitySeat = quantitySeat;
    }

    public Integer getIdShowRoom() {
        return idShowRoom;
    }

    public void setIdShowRoom(Integer idShowRoom) {
        this.idShowRoom = idShowRoom;
    }

    public String getNameShowRoom() {
        return nameShowRoom;
    }

    public void setNameShowRoom(String nameShowRoom) {
        this.nameShowRoom = nameShowRoom;
    }

    public Integer getQuantitySeat() {
        return quantitySeat;
    }

    public void setQuantitySeat(Integer quantitySeat) {
        this.quantitySeat = quantitySeat;
    }
}
