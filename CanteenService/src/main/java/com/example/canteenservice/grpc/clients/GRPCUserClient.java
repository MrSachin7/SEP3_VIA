package com.example.canteenservice.grpc;
import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.converters.UserConverter;
import grpcProtoFiles.UserOuterClass;
import grpcProtoFiles.UserServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GRPCUserClient implements UserClient {

    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private UserConverter userConverter;

    public GRPCUserClient( UserConverter userConverter) {
        this.userConverter = userConverter;
        this.userServiceBlockingStub = GrpcStubFactory.getUserServiceBlockingStub();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserOuterClass.User user =userConverter.toProto(userDTO);
        UserOuterClass.CreateUserRequest request = UserOuterClass.CreateUserRequest.newBuilder()
                .setUser(user).build();
        UserOuterClass.CreateUserResponse createdUser = userServiceBlockingStub.createUser(request);
        return userConverter.toDto(user);

    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }
}
