using EFC.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EFC; 

public class DatabaseAccess : DbContext {
    public DbSet<UserEntity> Users { get; set; }
    public DbSet<ReservationEntity> Reservations { get; set; }
    public DbSet<MenuEntity> Menus { get; set; }
    public DbSet<IngredientEntity> Ingredients { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
        optionsBuilder.UseSqlite(
            @"Data Source =C:\Users\nepal\OneDrive\Desktop\SEP3\CanteenServiceDatabaseServer\EFC\canteenDb.db");    }

    protected override void OnModelCreating(ModelBuilder modelBuilder) {
        modelBuilder.Entity<MenuIngredientEntity>().HasKey(entity => new{entity.MenuId, entity.IngredientName});
        modelBuilder.Entity<MenuIngredientEntity>().HasOne(entity => entity.Menu).WithMany(menuEntity  => menuEntity.MenuIngredients).HasForeignKey(entity => entity.MenuId);
        modelBuilder.Entity<MenuIngredientEntity>().HasOne(mi =>mi.Ingredient).WithMany(ingredient  => ingredient.MenuIngredients).HasForeignKey(mi => mi.IngredientName);
    }
}