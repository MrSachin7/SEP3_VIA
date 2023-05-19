package com.example.canteenservice.grpc.clients;

import com.example.canteenservice.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationClient {
    ReservationDTO createReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations();

    List<ReservationDTO> getReservationsByUsername(String username);

    ReservationDTO getReservationById(int reservationId);
}