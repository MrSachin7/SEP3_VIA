package com.example.canteenservice.dto;

import lombok.Data;

@Data
public class ReservationDTO {
    private int id;
    private UserDTO reservedBy;
    private MenuDTO menu;
    private int quantity;
    private boolean isDelivered;

}
