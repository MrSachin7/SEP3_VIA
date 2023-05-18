using System.ComponentModel.DataAnnotations.Schema;

namespace EFC.Entities; 

public class IngredientToMenuMapperEntity {
    [ForeignKey(nameof(IngredientNameEntity))]
    public string IngredientName { get; set; }

    [ForeignKey(nameof(MenuEntity))]
    public int MenuId { get; set; }
}