package com.example.canteenservice.services.impl;

import com.example.canteenservice.dto.CreateReservationDTO;
import com.example.canteenservice.dto.ReservationDTO;
import com.example.canteenservice.grpc.clients.ReservationClient;
import com.example.canteenservice.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationClient reservationClient;

    public ReservationServiceImpl(ReservationClient reservationClient) {
        this.reservationClient = reservationClient;
    }

    @Override
    public ReservationDTO createReservation(CreateReservationDTO reservationDTO) {
        return reservationClient.createReservation(reservationDTO);
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        return reservationClient.getAllReservations();
    }

    @Override
    public List<ReservationDTO> getReservationsByUsername(String username) {
        return reservationClient.getReservationsByUsername(username);
    }

    @Override
    public ReservationDTO getReservationById(int reservationId) {
        return reservationClient.getReservationById(reservationId);
    }
}
