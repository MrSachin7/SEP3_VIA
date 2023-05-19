package com.example.canteenservice.grpc.converters;

import com.example.canteenservice.dto.MenuDTO;
import grpcProtoFiles.MenuOuterClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuConverter {

    public MenuDTO toDTO(MenuOuterClass.Menu menu){
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setPrice(menu.getPrice());
        menuDTO.setIngredients(menu.getIngredientsList());
        return menuDTO;
    }

    public List<MenuDTO> toDTOList(List<MenuOuterClass.Menu> menus){
        // We map the list of menus to a list of menuDTOs
        return menus.stream().map(this::toDTO).toList();
    }

    public MenuOuterClass.Menu toProto(MenuDTO menuDTO){
        return MenuOuterClass.Menu.newBuilder()
                .setId(menuDTO.getId())
                .setName(menuDTO.getName())
                .setDescription(menuDTO.getDescription())
                .setPrice(menuDTO.getPrice())
                .addAllIngredients(menuDTO.getIngredients())
                .build();
    }
}
