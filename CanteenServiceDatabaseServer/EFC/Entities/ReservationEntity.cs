using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace EFC.Entities; 

public class ReservationEntity {
    [Key]
    public int Id { get; set; }

    public int Quantity { get; set; }

    [DefaultValue(false)]
    public bool IsDelivered { get; set; }
    public UserEntity ReservedBy { get; set; }
    public MenuEntity Menu { get; set; }
}