using System.Security.Claims;
using Contracts;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;

namespace BlazorApplication.Authentication; 

public class AuthenticationProvider :AuthenticationStateProvider {
    private IUserService _userService;
    private IAuthService _authService;

    public AuthenticationProvider(IUserService userService, IAuthService authService
    ) {
        this._userService = userService;
        this._authService = authService;
        _authService.OnAuthStateChanged += this.OnAuthStateChanged;

    }

    public override async Task<AuthenticationState> GetAuthenticationStateAsync() {
        var claimsPrincipal = await _authService.GetAuthAsync();
      return new AuthenticationState(claimsPrincipal);
    }

    private void OnAuthStateChanged(ClaimsPrincipal claimsPrincipal) {

        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(claimsPrincipal)));
    }
}