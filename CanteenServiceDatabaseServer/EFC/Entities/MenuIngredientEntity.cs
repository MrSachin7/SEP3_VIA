namespace EFC.Entities; 

public class MenuIngredientEntity {
    public int MenuId { get; set; }
    public MenuEntity Menu { get; set; }

    public string IngredientName { get; set; }
    public IngredientEntity Ingredient { get; set; }
}