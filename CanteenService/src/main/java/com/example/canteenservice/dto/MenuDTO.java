package com.example.canteenservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private List<String> ingredients;

}
