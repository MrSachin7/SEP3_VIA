using System.Security.Claims;
using System.Text.Json;
using Contracts;
using DTO;
using Microsoft.JSInterop;

namespace BlazorApplication.Authentication; 

public class AuthService : IAuthService {
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null;
    private readonly IUserService _userService;
    private readonly IJSRuntime _jsRuntime;

    public AuthService(IUserService userService, IJSRuntime jsRuntime) {
        this._userService = userService;
        this._jsRuntime = jsRuntime;
    }

    public async Task LoginAsync(string username, string password) {
        UserDTO userDto = await _userService.GetUserAsync(username);

        await CacheUserToSessionStorageAsync(userDto);
        ClaimsPrincipal principal = CreateClaimsPrincipal(userDto);

        OnAuthStateChanged.Invoke(principal);
    }


    public async Task LogOutAsync() {
        await ClearUserFromSessionStorage();
        ClaimsPrincipal principal = CreateClaimsPrincipal(null);
        OnAuthStateChanged.Invoke(principal);
    }


    public async Task<ClaimsPrincipal> GetAuthAsync() {
        UserDTO userDto = await GetUserFromCacheAsync();
        ClaimsPrincipal principal = CreateClaimsPrincipal(userDto);
        return principal;
    }


    private ClaimsPrincipal CreateClaimsPrincipal(UserDTO? userDto) {
        if (userDto != null) {
            ClaimsIdentity identity = CreateIdentityFromUser(userDto);
            return new ClaimsPrincipal(identity);
        }

        return new ClaimsPrincipal();
    }

    private ClaimsIdentity CreateIdentityFromUser(UserDTO userDto) {
        List<Claim> claims = new List<Claim>() {
            new Claim(ClaimTypes.Name, userDto.Username),
            new Claim("Role", userDto.Role)
        };
        return new ClaimsIdentity(claims, "apiauth_type");
    }

    private async Task CacheUserToSessionStorageAsync(UserDTO userDto) {
        string userAsJson = JsonSerializer.Serialize(userDto);
        await _jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", userAsJson);

    }

    private async Task<UserDTO> GetUserFromCacheAsync() {
        string userAsJson = await _jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
        if (string.IsNullOrEmpty(userAsJson)) return null;
        UserDTO user = JsonSerializer.Deserialize<UserDTO>(userAsJson)!;
        return user;
    }

    private async Task ClearUserFromSessionStorage() {
        await _jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
    }



}