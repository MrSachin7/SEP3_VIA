package com.example.canteenservice.dto;

import lombok.Data;

@Data
public class Reservation {
    private int id;
    private UserDTO user;
    private MenuDTO menu;
    private int quantity;
    private boolean isDelivered;

}
