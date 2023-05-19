package com.example.canteenservice.grpc.clients;

import com.example.canteenservice.dto.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuClient {
    MenuDTO createMenu(MenuDTO menuDTO);

    List<MenuDTO> getAllMenus();

    List<MenuDTO> getMenusByName(String name);

    MenuDTO getMenuById(int menuId);
}
