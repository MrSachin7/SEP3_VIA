package com.example.canteenservice.dto;

import lombok.Data;

@Data
public class CreateReservationDTO {
    private String reservedBy;
    private int menuId;
    private int quantity;

}
