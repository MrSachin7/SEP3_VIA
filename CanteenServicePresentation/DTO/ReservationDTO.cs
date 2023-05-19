namespace DTO; 

public class ReservationDTO {
    public int Id { get; set; }
    public UserDTO ReservedBy { get; set; }
    public MenuDTO Menu { get; set; }
    public int Quantity { get; set; }
    public bool IsDelivered { get; set; }

}