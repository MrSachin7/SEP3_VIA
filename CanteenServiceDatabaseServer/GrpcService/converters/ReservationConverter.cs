using DTO;
using Google.Protobuf.Collections;
using grpcProtoFiles;

namespace GrpcService.converters;

public class ReservationConverter {
    private readonly UserConverter _userConverter;
    private readonly MenuConverter _menuConverter;

    public ReservationConverter(UserConverter userConverter, MenuConverter menuConverter) {
        _userConverter = userConverter;
        _menuConverter = menuConverter;
    }


    public ReservationDTO ToDto(Reservation reservation) {
        return new ReservationDTO() {
            Id = reservation.Id,
            ReservedBy = _userConverter.ToDto(reservation.ReservedBy),
            Menu = _menuConverter.ToDto(reservation.Menu),
            Quantity = reservation.Quantity,
            IsDelivered = reservation.IsDelivered
        };
    }

    public List<ReservationDTO> ToListDto(RepeatedField<Reservation> reservations) {
        return reservations.Select(ToDto).ToList();
    }

    public Reservation ToProto(ReservationDTO reservationDto) {
        return new Reservation() {
            Id = reservationDto.Id,
            ReservedBy = _userConverter.ToProto(reservationDto.ReservedBy),
            Menu = _menuConverter.ToProto(reservationDto.Menu),
            Quantity = reservationDto.Quantity,
            IsDelivered = reservationDto.IsDelivered
        };
    }

    public RepeatedField<Reservation> ToListProto(List<ReservationDTO> reservations) {
        return new RepeatedField<Reservation>(){reservations.Select(ToProto).ToList()};
    }
}