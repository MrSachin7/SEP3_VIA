using System.ComponentModel.DataAnnotations;

namespace EFC.Entities; 

public class MenuEntity {
    [Key]
    public int Id { get; set; }
    [Required]
    public string Name { get; set; }
    public string? Description { get; set; }
    public double Price{ get; set; }
    public List<IngredientNameEntity>? Ingredients { get; set; }

}