package com.example.canteenservice.grpc.clients;

import com.example.canteenservice.dto.CreateReservationDTO;
import com.example.canteenservice.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationClient {
    ReservationDTO createReservation(CreateReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations();

    List<ReservationDTO> getReservationsByUsername(String username);

    ReservationDTO getReservationById(int reservationId);
}
