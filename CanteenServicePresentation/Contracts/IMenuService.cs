using DTO;

namespace Contracts; 

public interface IMenuService {
    Task<MenuDTO> CreateMenuAsync(MenuDTO menuDto);
    Task<List<MenuDTO>> GetAllMenusAsync();
    Task<List<MenuDTO>> GetAllMenusByUserAsync(string username);
    Task<MenuDTO> GetMenuByIdAsync(int id);

}