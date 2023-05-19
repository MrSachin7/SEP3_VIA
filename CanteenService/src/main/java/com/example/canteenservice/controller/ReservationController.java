package com.example.canteenservice.controller;

import com.example.canteenservice.dto.ReservationDTO;
import com.example.canteenservice.services.ReservationService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity createReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            ReservationDTO createdReservation = reservationService.createReservation(reservationDTO);
            return ResponseEntity.ok(createdReservation);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/reservations")
    public ResponseEntity getReservations(@PathParam("username") String username) {
        List<ReservationDTO> reservationDTOS;
        try {
            if (username == null || username.equals("")) {
                reservationDTOS = reservationService.getAllReservations();
            } else {
                reservationDTOS = reservationService.getReservationsByUsername(username);
            }
            return ResponseEntity.ok(reservationDTOS);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/reservations/{reservationId}")
    public ResponseEntity getReservationById(@PathParam("reservationId") int reservationId) {
        try {
            ReservationDTO reservationDTO = reservationService.getReservationById(reservationId);
            return ResponseEntity.ok(reservationDTO);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

}
