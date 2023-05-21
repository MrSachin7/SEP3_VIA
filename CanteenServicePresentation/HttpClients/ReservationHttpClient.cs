﻿using Contracts;
using DTO;

namespace HttpClients;

public class ReservationHttpClient : IReservationService {
    public async Task<ReservationDTO> CreateReservationAsync(CreateReservationDTO reservationDto) {
        return await HttpClientUtil.SendHttpPostRequest<CreateReservationDTO, ReservationDTO>(
            "reservations", reservationDto);
    }

    public async Task<ReservationDTO> GetReservationById(int reservationId) {
        return await HttpClientUtil.SendHttpGetRequest<ReservationDTO, ReservationDTO>(
            $"reservations/{reservationId}");
    }

    public async Task<List<ReservationDTO>> GetReservationsByUsername(string username) {
        return await HttpClientUtil.SendHttpGetRequest<ReservationDTO, List<ReservationDTO>>(
            $"reservations?username={username}");
    }

    public async Task<List<ReservationDTO>> GetAllReservations() {
        return await HttpClientUtil.SendHttpGetRequest<ReservationDTO, List<ReservationDTO>>(
            "reservations");
    }
}