using DTO;
using EFC.Entities;

namespace EFC.converters; 

public class MenuConverter {
    public MenuDTO ToDto(MenuEntity menu) {
        return new MenuDTO {
            Id = menu.Id,
            Name = menu.Name,
            Description = menu.Description,
            Price = menu.Price,
            // If menu.Ingredients is null, then return an empty list, otherwise return a list of strings mapped from the IngredientEntities
            Ingredients = menu.MenuIngredients == null ? new List<string>() : menu.MenuIngredients.Select(i => i.IngredientName).ToList()
        };
    }

    public List<MenuDTO> ToDtoList(List<MenuEntity> entities) {
        return entities.Select(ToDto).ToList();

    }

    public MenuEntity ToEntity(MenuDTO menu) {
        return new MenuEntity {
            Id = menu.Id,
            Name = menu.Name,
            Description = menu.Description,
            Price = menu.Price,
            // If menu.Ingredients is null, then return an empty list, otherwise return a list of IngredientEntities created from the strings
            MenuIngredients = menu.Ingredients == null ? new List<MenuIngredientEntity>() : menu.Ingredients.Select(ingredientString => new MenuIngredientEntity(){IngredientName = ingredientString}).ToList()
        };
    }
}