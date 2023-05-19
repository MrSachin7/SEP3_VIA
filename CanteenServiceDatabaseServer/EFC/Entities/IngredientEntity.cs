using System.ComponentModel.DataAnnotations;

namespace EFC.Entities; 

public class IngredientEntity {
    [Key]
    public string IngredientName { get; set; }

    public List<MenuIngredientEntity> MenuIngredients { get; set; }

}