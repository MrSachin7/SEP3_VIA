package com.example.canteenservice.grpc.clients.impl;
import com.example.canteenservice.dto.CreateReservationDTO;
import com.example.canteenservice.dto.ReservationDTO;
import com.example.canteenservice.grpc.GrpcStubFactory;
import com.example.canteenservice.grpc.clients.ReservationClient;
import com.example.canteenservice.grpc.converters.ReservationConverter;
import grpcProtoFiles.ReservationOuterClass;
import grpcProtoFiles.ReservationServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationClientImpl implements ReservationClient {

    private final ReservationConverter reservationConverter;
    private final ReservationServiceGrpc.ReservationServiceBlockingStub reservationServiceBlockingStub;

    public ReservationClientImpl(ReservationConverter reservationConverter, GrpcStubFactory factory) {
        this.reservationConverter = reservationConverter;
        this.reservationServiceBlockingStub = factory.getReservationServiceBlockingStub();
    }

    @Override
    public ReservationDTO createReservation(CreateReservationDTO reservationDTO) {
        var request = ReservationOuterClass.CreateReservationRequest.newBuilder()
                .setReservedByUsername(reservationDTO.getReservedBy())
                .setMenuId(reservationDTO.getMenuId())
                .setQuantity(reservationDTO.getQuantity())
                .build();
        var reservationResponse = reservationServiceBlockingStub.createReservation(request);
        return reservationConverter.toDTO(reservationResponse.getReservation());

    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        var request = ReservationOuterClass.GetAllReservationsRequest.newBuilder().build();
        var reservationResponse = reservationServiceBlockingStub.getAllReservations(request);
        return reservationConverter.toDTOList(reservationResponse.getReservationsList());

    }

    @Override
    public List<ReservationDTO> getReservationsByUsername(String username) {
        var request = ReservationOuterClass.GetReservationsByUserRequest.newBuilder()
                .setUsername(username)
                .build();
        var reservationResponse = reservationServiceBlockingStub.getReservationsByUser(request);
        return reservationConverter.toDTOList(reservationResponse.getReservationsList());
    }

    @Override
    public ReservationDTO getReservationById(int reservationId) {
        var request = ReservationOuterClass.GetReservationRequest.newBuilder()
                .setId(reservationId)
                .build();
        var reservationResponse = reservationServiceBlockingStub.getReservation(request);
        return reservationConverter.toDTO(reservationResponse.getReservation());
    }
}
