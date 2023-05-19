package com.example.canteenservice.services;

import com.example.canteenservice.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    ReservationDTO createReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations();

    List<ReservationDTO> getReservationsByUsername(String username);

    ReservationDTO getReservationById(int reservationId);
}
