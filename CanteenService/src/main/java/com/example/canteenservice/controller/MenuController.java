package com.example.canteenservice.controller;
import com.example.canteenservice.dto.MenuDTO;
import com.example.canteenservice.services.impl.MenuService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping(value = "/menus")
    public ResponseEntity createMenu(@RequestBody MenuDTO menuDTO) {
        try {
            MenuDTO addedMenu = menuService.createMenu(menuDTO);
            return ResponseEntity.ok(addedMenu);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    // Path param allows us to have same endpoint for getting all menus as well as
    // searching for menus
    @GetMapping(value = "/menus")
    public ResponseEntity getMenus(@PathParam("name") String name) {
        try {
            List<MenuDTO> menuDTOS;
            if (name == null || name.equals("")) {
                menuDTOS = menuService.getAllMenus();
            } else {
                menuDTOS = menuService.getMenusByName(name);
            }
            return ResponseEntity.ok(menuDTOS);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/menus/{menuId}")
    public ResponseEntity getMenusById(@PathVariable("menuId") int menuId) {
        try {
            MenuDTO menuDTO = menuService.getMenuById(menuId);
            return ResponseEntity.ok(menuDTO);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }
}
