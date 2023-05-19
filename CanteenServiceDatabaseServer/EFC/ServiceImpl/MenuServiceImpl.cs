using Contracts;
using DTO;
using EFC.converters;
using EFC.Entities;
using Microsoft.EntityFrameworkCore;

namespace EFC.ServiceImpl;

public class MenuServiceImpl : IMenuService {
    private readonly DatabaseAccess _databaseAccess;
    private readonly MenuConverter _menuConverter;

    public MenuServiceImpl(DatabaseAccess databaseAccess, MenuConverter menuConverter) {
        _databaseAccess = databaseAccess;
        _menuConverter = menuConverter;
    }

    public async Task<MenuDTO> AddMenu(MenuDTO menuDto) {
        var menuEntity = _menuConverter.ToEntity(menuDto);
        await AddIngredientsIfNotExists(menuEntity);
        var addedMenu = await _databaseAccess.Menus.AddAsync(menuEntity);
        await _databaseAccess.SaveChangesAsync();
        return _menuConverter.ToDto(addedMenu.Entity);
    }

    private async Task AddIngredientsIfNotExists(MenuEntity menuEntity) {
        List<MenuIngredientEntity>? menuIngredientEntities = menuEntity.MenuIngredients;
        if (menuIngredientEntities == null) return; 
        foreach (var menuIngredientEntity in menuIngredientEntities) {
          var ingredient = await _databaseAccess.Ingredients.FindAsync(menuIngredientEntity.IngredientName);
          if (ingredient == null){
              await _databaseAccess.Ingredients.AddAsync(new IngredientEntity(){IngredientName = menuIngredientEntity.IngredientName});
          }
        }
    }

    public async Task<MenuDTO> GetMenuById(int id) {
        var menuById = await _databaseAccess.Menus.Include(entity => entity!.MenuIngredients!)
            .ThenInclude(menuIngredient => menuIngredient.Ingredient).FirstOrDefaultAsync(menu => menu.Id == id);
        if (menuById == null) {
            throw new Exception("Menu not found");
        }
        return _menuConverter.ToDto(menuById);
    }


    public async Task<List<MenuDTO>> GetAllMenus() {
        var menus = await _databaseAccess.Menus.Include(entity => entity!.MenuIngredients!)
            .ThenInclude(menuIngredient => menuIngredient.Ingredient).ToListAsync();
        return menus.Select(menu => _menuConverter.ToDto(menu)).ToList();
        
    }

    public async Task<List<MenuDTO>> GetMenusByName(string requestName) {
        var menus = await _databaseAccess.Menus.Include(entity => entity!.MenuIngredients!)
            .ThenInclude(menuIngredient => menuIngredient.Ingredient).Where(menu => menu.Name.ToUpper().Contains(requestName.ToUpper())).ToListAsync();
        return _menuConverter.ToDtoList(menus); 
    }
}