using Contracts;
using DTO;
using Grpc.Core;
using GrpcService.converters;

namespace GrpcService.GrpcController; 

using grpcProtoFiles;

public class MenuController : MenuService.MenuServiceBase {
    private readonly IMenuService _menuService;
    private readonly MenuConverter _menuConverter;

    public MenuController(IMenuService menuService, MenuConverter menuConverter) {
        _menuService = menuService;
        _menuConverter = menuConverter;
    }
    public override async Task<CreateMenuResponse> CreateMenu(CreateMenuRequest request, ServerCallContext context) {
       MenuDTO menuDto= _menuConverter.ToDto(request.Menu);
     MenuDTO addedMenu = await _menuService.AddMenu(menuDto);
     return new CreateMenuResponse() {
         Menu = _menuConverter.ToProto(addedMenu)
     };
    }

    public override async Task<GetMenuResponse> GetMenu(GetMenuRequest request, ServerCallContext context) {
        int id = request.Id;
        MenuDTO menuDto = await _menuService.GetMenuById(id);
        return new GetMenuResponse() {
            Menu = _menuConverter.ToProto(menuDto)
        };
    }


    public override async Task<GetMenusResponse> GetAllMenu(GetAllMenuRequest request, ServerCallContext context) {
        List<MenuDTO> allMenus = await _menuService.GetAllMenus();
        return new GetMenusResponse() {
            Menu = {_menuConverter.ToProtoList(allMenus)}
        };
    }

    public override async Task<GetMenusResponse> GetMenuByName(GetMenuByNameRequest request, ServerCallContext context) {
        List<MenuDTO> menusByName = await _menuService.GetMenusByName(request.Name);
        return new GetMenusResponse() {
            Menu = {_menuConverter.ToProtoList(menusByName)}
        };

    }
}