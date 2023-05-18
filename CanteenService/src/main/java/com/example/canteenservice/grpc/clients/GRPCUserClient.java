package com.example.canteenservice.grpc.clients;
import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.GrpcStubFactory;
import com.example.canteenservice.grpc.UserClient;
import com.example.canteenservice.grpc.converters.UserConverter;
import grpcProtoFiles.UserOuterClass;
import grpcProtoFiles.UserServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GRPCUserClient implements UserClient {
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private final UserConverter userConverter;

    public GRPCUserClient( UserConverter userConverter, GrpcStubFactory factory) {
        this.userConverter = userConverter;
        this.userServiceBlockingStub = factory.getUserServiceBlockingStub();
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserOuterClass.User user =userConverter.toProto(userDTO);
        UserOuterClass.CreateUserRequest request = UserOuterClass.CreateUserRequest.newBuilder()
                .setUser(user).build();
        UserOuterClass.CreateUserResponse createdUserResponse = userServiceBlockingStub.createUser(request);
        return userConverter.toDto(createdUserResponse.getUser());
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }
}
