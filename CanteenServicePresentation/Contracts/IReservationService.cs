using System.Reflection.Metadata;
using System.Runtime.InteropServices;
using DTO;

namespace Contracts; 

public interface IReservationService {
    Task<ReservationDTO> CreateReservationAsync(CreateReservationDTO reservationDto);
    Task<ReservationDTO> GetReservationById(int reservationId);
    Task<List<ReservationDTO>> GetReservationsByUsername(string username);
    Task<List<ReservationDTO>> GetAllReservations();
}