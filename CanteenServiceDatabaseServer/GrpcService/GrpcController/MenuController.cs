using Contracts;
using Grpc.Core;

namespace GrpcService.GrpcController; 

using grpcProtoFiles;

public class MenuController : MenuService.MenuServiceBase {
    private readonly IMenuService _menuService;

    public MenuController(IMenuService menuService) {
        _menuService = menuService;
    }
    public override async Task<CreateMenuResponse> CreateMenu(CreateMenuRequest request, ServerCallContext context) {
        await _menuService.CreateMenu(request.Menu);
    }

    public override Task<GetMenuResponse> GetMenu(GetMenuRequest request, ServerCallContext context) {
        return base.GetMenu(request, context);
    }

    public override Task<GetMenusResponse> GetAllMenu(GetAllMenuRequest request, ServerCallContext context) {
        return base.GetAllMenu(request, context);
    }

    public override Task<GetMenusResponse> GetMenuByName(GetMenuByNameRequest request, ServerCallContext context) {
        return base.GetMenuByName(request, context);
    }
}