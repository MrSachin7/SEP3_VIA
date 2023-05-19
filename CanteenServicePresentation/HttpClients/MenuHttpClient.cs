using Contracts;
using DTO;

namespace HttpClients; 

public class MenuHttpClient : IMenuService {
    public async Task<MenuDTO> CreateMenuAsync(MenuDTO menuDto) {
        return await HttpClientUtil.SendHttpPostRequest<MenuDTO, MenuDTO>("/menus", menuDto);
    }

    public async Task<List<MenuDTO>> GetAllMenusAsync() {
        return await HttpClientUtil.SendHttpGetRequest<MenuDTO, List<MenuDTO>>("/menus");
    }

    public async Task<List<MenuDTO>> GetAllMenusByUserAsync(string username) {
        return await HttpClientUtil.SendHttpGetRequest<MenuDTO, List<MenuDTO>>($"/menus?username={username}");
    }

    public async Task<MenuDTO> GetMenuByIdAsync(int id) {
        return await HttpClientUtil.SendHttpGetRequest<MenuDTO, MenuDTO>($"/menus/{id}");
    }
}