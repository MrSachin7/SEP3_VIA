using DTO;
using EFC.Entities;

namespace EFC.converters;

public class ReservationConverter {
    private readonly UserConverter userConverter;
    private readonly MenuConverter menuConverter;

    public ReservationConverter(UserConverter userConverter, MenuConverter menuConverter) {
        this.userConverter = userConverter;
        this.menuConverter = menuConverter;
    }

    public ReservationDTO ToDto(ReservationEntity entity) {
        return new ReservationDTO() {
            Id = entity.Id,
            ReservedBy = userConverter.ToDTO(entity.ReservedBy),
            Menu = menuConverter.ToDto(entity.Menu),
            Quantity = entity.Quantity,
            IsDelivered = entity.IsDelivered
        };
    }

    public List<ReservationDTO> ToDtoList(List<ReservationEntity> entities) {
        return entities.Select(ToDto).ToList();
    }

    public ReservationEntity ToEntity(ReservationDTO dto) {
        return new ReservationEntity() {
            Id = dto.Id,
            ReservedBy = userConverter.ToEntity(dto.ReservedBy),
            Menu = menuConverter.ToEntity(dto.Menu),
            Quantity = dto.Quantity,
            IsDelivered = dto.IsDelivered
        };
    }
}