using Contracts;
using DTO;
using EFC.converters;
using Microsoft.EntityFrameworkCore;

namespace EFC.ServiceImpl;

public class ReservationServiceImpl : IReservationService {
    private readonly ReservationConverter _reservationConverter;
    private readonly DatabaseAccess _databaseAccess;

    public ReservationServiceImpl(ReservationConverter reservationConverter, DatabaseAccess databaseAccess) {
        _reservationConverter = reservationConverter;
        this._databaseAccess = databaseAccess;
    }

    public async Task<ReservationDTO> AddReservation(ReservationDTO reservation) {
        var reservationEntity = _reservationConverter.ToEntity(reservation);
        var added = await _databaseAccess.Reservations.AddAsync(reservationEntity);
        await _databaseAccess.SaveChangesAsync();
        return _reservationConverter.ToDto(added.Entity);
    }

    public async Task<ReservationDTO> GetReservation(int id) {
        var reservation = await _databaseAccess.Reservations.Include(entity => entity.ReservedBy)
            .Include(entity => entity.Menu)
            .FirstOrDefaultAsync(entity => entity.Id == id);
        if (reservation == null) {
            throw new Exception("Reservation not found");
        }

        return _reservationConverter.ToDto(reservation);
    }

    public async Task<List<ReservationDTO>> GetAllReservations() {
        var reservations = await _databaseAccess.Reservations.Include(entity => entity.ReservedBy)
            .Include(entity => entity.Menu).ToListAsync();
        return _reservationConverter.ToDtoList(reservations);
    }

    public async Task<List<ReservationDTO>> GetReservationsByUser(string username) {
        var reservations = await _databaseAccess.Reservations.Include(entity => entity.ReservedBy)
            .Include(entity => entity.Menu)
            .Where(entity => entity.ReservedBy.Username == username).ToListAsync();
        if (reservations == null) {
            throw new Exception("Reservation not found");
        }
        return _reservationConverter.ToDtoList(reservations);
    }
}