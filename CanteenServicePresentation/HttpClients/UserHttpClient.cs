using Contracts;
using DTO;

namespace HttpClients; 

public class UserHttpClient : IUserService {

    public async Task<UserDTO> CreateUserAsync(UserDTO userDto) {
        return await HttpClientUtil.SendHttpPostRequest<UserDTO, UserDTO>("/users", userDto);
    }

    public async Task<UserDTO> GetUserAsync(string username) {
        return await HttpClientUtil.SendHttpGetRequest<UserDTO, UserDTO>($"/users/{username}");
    }
}