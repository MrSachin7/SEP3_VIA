package com.example.canteenservice.services;

import com.example.canteenservice.dto.MenuDTO;
import com.example.canteenservice.grpc.MenuClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuClient menuClient;

    public MenuService(MenuClient menuClient) {
        this.menuClient = menuClient;
    }

    public MenuDTO createMenu(MenuDTO menuDTO) {
        return menuClient.createMenu(menuDTO);
    }

    public List<MenuDTO> getAllMenus() {
        return menuClient.getAllMenus();
    }

    public List<MenuDTO> getMenusByName(String name) {
        return menuClient.getMenusByName(name);
    }

    public MenuDTO getMenuById(int menuId) {
        return menuClient.getMenuById(menuId);
    }
}
