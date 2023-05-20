using BlazorApplication.Authentication;
using BlazorApplication.Data;
using Contracts;
using HttpClients;
using Microsoft.AspNetCore.Components.Authorization;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();
builder.Services.AddSingleton<WeatherForecastService>();

builder.Services.AddScoped<IUserService, UserHttpClient>();
builder.Services.AddScoped<IReservationService, ReservationHttpClient>();
builder.Services.AddScoped<IMenuService, MenuHttpClient>();
builder.Services.AddScoped<AuthenticationStateProvider, AuthenticationProvider>();
builder.Services.AddScoped<IAuthService, AuthService>();

builder.Services.AddAuthorization(options => {
    options.AddPolicy("Admin", policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Admin"));
    options.AddPolicy("Guest", policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Guest"));
    options.AddPolicy("All",
        policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Guest", "Admin"));

});
var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();

app.UseStaticFiles();

app.UseRouting();

app.MapBlazorHub();
app.MapFallbackToPage("/_Host");

app.Run();
