using DTO;

namespace Contracts; 

public interface IMenuService {
    Task<MenuDTO> AddMenu(MenuDTO menuDto);
    Task<MenuDTO> GetMenuById(int id);
    Task<List<MenuDTO>> GetAllMenus();
    Task<List<MenuDTO>> GetMenusByName(string requestName);
}