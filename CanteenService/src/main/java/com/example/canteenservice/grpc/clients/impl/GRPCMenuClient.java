package com.example.canteenservice.grpc.clients.impl;

import com.example.canteenservice.dto.MenuDTO;
import com.example.canteenservice.grpc.GrpcStubFactory;
import com.example.canteenservice.grpc.clients.MenuClient;
import com.example.canteenservice.grpc.converters.MenuConverter;
import grpcProtoFiles.MenuOuterClass;
import grpcProtoFiles.MenuServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GRPCMenuClient implements MenuClient {

    private final MenuServiceGrpc.MenuServiceBlockingStub menuService;
    private final MenuConverter menuConverter;

    public GRPCMenuClient(GrpcStubFactory stubFactory, MenuConverter menuConverter) {
        this.menuService = stubFactory.getMenuServiceBlockingStub();
        this.menuConverter = menuConverter;
    }

    @Override
    public MenuDTO createMenu(MenuDTO menuDTO) {
        MenuOuterClass.Menu menuProto = menuConverter.toProto(menuDTO);
        MenuOuterClass.CreateMenuRequest request = MenuOuterClass.CreateMenuRequest.newBuilder()
                .setMenu(menuProto)
                .build();
        MenuOuterClass.CreateMenuResponse createResponse = menuService.createMenu(request);
        return menuConverter.toDTO(createResponse.getMenu());
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        MenuOuterClass.GetAllMenuRequest request = MenuOuterClass.GetAllMenuRequest.newBuilder().build();
        MenuOuterClass.GetMenusResponse response = menuService.getAllMenu(request);
        return menuConverter.toDTOList(response.getMenuList());
    }

    @Override
    public List<MenuDTO> getMenusByName(String name) {
        MenuOuterClass.GetMenuByNameRequest request = MenuOuterClass.GetMenuByNameRequest.newBuilder()
                .setName(name)
                .build();
        MenuOuterClass.GetMenusResponse response = menuService.getMenuByName(request);
        return menuConverter.toDTOList(response.getMenuList());
    }

    @Override
    public MenuDTO getMenuById(int menuId) {
        MenuOuterClass.GetMenuRequest request = MenuOuterClass.GetMenuRequest.newBuilder()
                .setId(menuId)
                .build();
        MenuOuterClass.GetMenuResponse response = menuService.getMenu(request);
        return menuConverter.toDTO(response.getMenu());
    }
}
