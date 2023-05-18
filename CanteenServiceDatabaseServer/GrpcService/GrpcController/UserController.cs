using Contracts;
using Grpc.Core;
using grpcProtoFiles;

namespace GrpcService.GrpcController; 

public class UserController : UserService.UserServiceBase {

    private readonly IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }
    public override Task<CreateUserResponse> CreateUser(CreateUserRequest request, ServerCallContext context) {
        return base.CreateUser(request, context);
    }

    public override Task<GetUserByUsernameResponse> GetUserByUsername(GetUserByUsernameRequest request, ServerCallContext context) {
        return base.GetUserByUsername(request, context);
    }
}