using System.ComponentModel.DataAnnotations;

namespace EFC.Entities; 

public class IngredientNameEntity {
    [Key]
    public string Ingredient { get; set; }

}