using Contracts;
using EFC;
using EFC.converters;
using EFC.ServiceImpl;
using grpcProtoFiles;
using GrpcService.GrpcController;
using GrpcService.Services;
using UserService = grpcProtoFiles.UserService;

var builder = WebApplication.CreateBuilder(args);

// Additional configuration is required to successfully run gRPC on macOS.
// For instructions on how to configure Kestrel and gRPC clients on macOS, visit https://go.microsoft.com/fwlink/?linkid=2099682

// Add services to the container.
builder.Services.AddDbContext<DatabaseAccess>();
builder.Services.AddGrpc();
builder.Services.AddScoped<IUserService, UserServiceImpl>();
builder.Services.AddScoped<MenuConverter>();
builder.Services.AddScoped<ReservationConverter>();
builder.Services.AddScoped<UserConverter>();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGrpcService<UserController>();
app.MapGet("/", () => "Communication with gRPC endpoints must be made through a gRPC client. To learn how to create a client, visit: https://go.microsoft.com/fwlink/?linkid=2086909");

app.Run();
