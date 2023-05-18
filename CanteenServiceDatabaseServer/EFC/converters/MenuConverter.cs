using DTO;
using EFC.Entities;

namespace EFC.converters; 

public class MenuConverter {
    public MenuDTO ToDTO(MenuEntity menu) {
        return new MenuDTO {
            Id = menu.Id,
            Name = menu.Name,
            Description = menu.Description,
            Price = menu.Price,
            // If menu.Ingredients is null, then return an empty list, otherwise return a list of strings mapped from the IngredientEntities
            Ingredients = menu.Ingredients == null ? new List<string>() : menu.Ingredients.Select(i => i.IngredientName).ToList()
        };
    }

    public MenuEntity ToEntity(MenuDTO menu) {
        return new MenuEntity {
            Id = menu.Id,
            Name = menu.Name,
            Description = menu.Description,
            Price = menu.Price,
            // If menu.Ingredients is null, then return an empty list, otherwise return a list of IngredientEntities created from the strings
            Ingredients =menu.Ingredients == null ? new List<IngredientEntity>() : menu.Ingredients.Select(ingredientString => new IngredientEntity(){IngredientName = ingredientString}).ToList()
        };
    }
}