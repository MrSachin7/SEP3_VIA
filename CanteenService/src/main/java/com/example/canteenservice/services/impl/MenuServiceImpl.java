package com.example.canteenservice.services.impl;

import com.example.canteenservice.dto.MenuDTO;
import com.example.canteenservice.grpc.clients.MenuClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements com.example.canteenservice.services.MenuService {

    private final MenuClient menuClient;

    public MenuServiceImpl(MenuClient menuClient) {
        this.menuClient = menuClient;
    }

    @Override
    public MenuDTO createMenu(MenuDTO menuDTO) {
        return menuClient.createMenu(menuDTO);
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        return menuClient.getAllMenus();
    }

    @Override
    public List<MenuDTO> getMenusByName(String name) {
        return menuClient.getMenusByName(name);
    }

    @Override
    public MenuDTO getMenuById(int menuId) {
        return menuClient.getMenuById(menuId);
    }
}
