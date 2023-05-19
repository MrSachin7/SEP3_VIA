package com.example.canteenservice.grpc.converters;

import com.example.canteenservice.dto.CreateReservationDTO;
import com.example.canteenservice.dto.ReservationDTO;
import grpcProtoFiles.ReservationOuterClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationConverter {

    private final UserConverter userConverter;
    private final MenuConverter menuConverter;

    public ReservationConverter(UserConverter userConverter, MenuConverter menuConverter) {
        this.userConverter = userConverter;
        this.menuConverter = menuConverter;
    }

    public ReservationDTO toDTO(ReservationOuterClass.Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setMenu(menuConverter.toDTO(reservation.getMenu()));
        reservationDTO.setReservedBy(userConverter.toDto(reservation.getReservedBy()));
        reservationDTO.setQuantity(reservation.getQuantity());
        reservationDTO.setDelivered(reservation.getIsDelivered());
        return reservationDTO;
    }

    public List<ReservationDTO> toDTOList(List<ReservationOuterClass.Reservation> reservations){
        // We map the list of reservations to a list of reservationDTOs
        return reservations.stream().map(this::toDTO).toList();
    }

    public ReservationOuterClass.Reservation toProto(ReservationDTO reservationDTO){
        return ReservationOuterClass.Reservation.newBuilder()
                .setId(reservationDTO.getId())
                .setMenu(menuConverter.toProto(reservationDTO.getMenu()))
                .setReservedBy(userConverter.toProto(reservationDTO.getReservedBy()))
                .setQuantity(reservationDTO.getQuantity())
                .setIsDelivered(reservationDTO.isDelivered())
                .build();
    }

}
