using DTO;

namespace Contracts; 

public interface IReservationService {
    Task<ReservationDTO> AddReservation(ReservationDTO reservation);
    Task<ReservationDTO> GetReservation(int id);
    Task<List<ReservationDTO>> GetAllReservations();
    Task<List<ReservationDTO>> GetReservationsByUser(string username);
}