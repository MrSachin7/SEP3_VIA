package com.example.canteenservice.grpcClient;


import grpcProtoFiles.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GrpcStubFactory {
    private static ManagedChannel managedChannel;
    private static final Lock lock = new ReentrantLock();

    private static UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;


    private GrpcStubFactory() {
    }

    public static ManagedChannel getManagedChannel() {
        if (managedChannel == null) {
            synchronized (lock) {
                if (managedChannel == null) {
                    managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                            .usePlaintext()
                            .build();
                }
            }
        }
        return managedChannel;
    }

    public static UserServiceGrpc.UserServiceBlockingStub getUserServiceBlockingStub(){
        if (userServiceBlockingStub == null) {
            userServiceBlockingStub = UserServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return userServiceBlockingStub;
    }

}
