using EFC.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EFC; 

public class DatabaseAccess : DbContext {
    public DbSet<UserEntity> Users { get; set; }
    public DbSet<ReservationEntity> Reservations { get; set; }
    public MenuEntity Menus { get; set; }
    public IngredientNameEntity IngredientNameEntity { get; set; }
    public IngredientToMenuMapperEntity IngredientsToMenuMapper { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
        optionsBuilder.UseSqlite(
            @"Data Source =C:\Users\nepal\OneDrive\Desktop\SEP3\CanteenServiceDatabaseServer\EFC\canteenDb.db");    }

    protected override void OnModelCreating(ModelBuilder modelBuilder) {
       modelBuilder.Entity<IngredientToMenuMapperEntity>().HasKey(entity => new {Ingredient = entity.IngredientName, entity.MenuId});
    }
}