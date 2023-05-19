package com.example.canteenservice.controller;

import com.example.canteenservice.dto.CreateReservationDTO;
import com.example.canteenservice.dto.ReservationDTO;
import com.example.canteenservice.services.ReservationService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity createReservation(@RequestBody CreateReservationDTO reservationDTO) {
        try {
            ReservationDTO createdReservation = reservationService.createReservation(reservationDTO);
            return ResponseEntity.ok(createdReservation);
        } catch (Exception e) {
            throw e;
//            return ResponseUtil.internalServerError(e);
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
    public ResponseEntity getReservationById(@PathVariable("reservationId") int reservationId) {
        try {
            ReservationDTO reservationDTO = reservationService.getReservationById(reservationId);
            return ResponseEntity.ok(reservationDTO);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

}
