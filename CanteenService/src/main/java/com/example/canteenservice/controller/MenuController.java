package com.example.canteenservice.controller;
import com.example.canteenservice.dto.MenuDTO;
import com.example.canteenservice.services.impl.MenuServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    private final MenuServiceImpl menuServiceImpl;

    public MenuController(MenuServiceImpl menuServiceImpl) {
        this.menuServiceImpl = menuServiceImpl;
    }

    @PostMapping(value = "/menus")
    public ResponseEntity createMenu(@RequestBody MenuDTO menuDTO) {
        try {
            System.out.println("Create menu controller" + menuDTO);
            MenuDTO addedMenu = menuServiceImpl.createMenu(menuDTO);
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
                menuDTOS = menuServiceImpl.getAllMenus();
            } else {
                menuDTOS = menuServiceImpl.getMenusByName(name);
            }
            return ResponseEntity.ok(menuDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/menus/{menuId}")
    public ResponseEntity getMenuById(@PathVariable("menuId") int menuId) {
        try {
            MenuDTO menuDTO = menuServiceImpl.getMenuById(menuId);
            return ResponseEntity.ok(menuDTO);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }
}
