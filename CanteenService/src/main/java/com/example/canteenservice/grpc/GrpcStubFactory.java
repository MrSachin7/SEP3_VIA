package com.example.canteenservice.grpc;
import grpcProtoFiles.MenuServiceGrpc;
import grpcProtoFiles.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(value = "singleton")
public class GrpcStubFactory {
    private  ManagedChannel managedChannel;
    private  UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    private MenuServiceGrpc.MenuServiceBlockingStub menuServiceBlockingStub;

    public ManagedChannel getManagedChannel() {
        if (managedChannel == null) {
            managedChannel = ManagedChannelBuilder.forAddress("localhost", 5081)
                    .usePlaintext()
                    .build();
        }
        return managedChannel;
    }

    public UserServiceGrpc.UserServiceBlockingStub getUserServiceBlockingStub() {
        if (userServiceBlockingStub == null) {
            userServiceBlockingStub = UserServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return userServiceBlockingStub;
    }

    public MenuServiceGrpc.MenuServiceBlockingStub getMenuServiceBlockingStub() {
        if (menuServiceBlockingStub == null) {
            menuServiceBlockingStub = MenuServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return menuServiceBlockingStub;
    }

}
