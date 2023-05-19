package com.example.canteenservice.dto;

import lombok.Data;

@Data
public class CreateReservationDTO {
    private String reservedByUsername;
    private int menuId;
    private int quantity;

}
