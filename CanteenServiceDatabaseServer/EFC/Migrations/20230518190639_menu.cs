using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace EFC.Migrations
{
    /// <inheritdoc />
    public partial class menu : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Reservations_MenuEntity_MenuId",
                table: "Reservations");

            migrationBuilder.DropTable(
                name: "IngredientNameEntity");

            migrationBuilder.DropTable(
                name: "IngredientToMenuMapperEntity");

            migrationBuilder.DropPrimaryKey(
                name: "PK_MenuEntity",
                table: "MenuEntity");

            migrationBuilder.RenameTable(
                name: "MenuEntity",
                newName: "Menus");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Menus",
                table: "Menus",
                column: "Id");

            migrationBuilder.CreateTable(
                name: "IngredientEntity",
                columns: table => new
                {
                    IngredientName = table.Column<string>(type: "TEXT", nullable: false),
                    MenuEntityId = table.Column<int>(type: "INTEGER", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_IngredientEntity", x => x.IngredientName);
                    table.ForeignKey(
                        name: "FK_IngredientEntity_Menus_MenuEntityId",
                        column: x => x.MenuEntityId,
                        principalTable: "Menus",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateIndex(
                name: "IX_IngredientEntity_MenuEntityId",
                table: "IngredientEntity",
                column: "MenuEntityId");

            migrationBuilder.AddForeignKey(
                name: "FK_Reservations_Menus_MenuId",
                table: "Reservations",
                column: "MenuId",
                principalTable: "Menus",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Reservations_Menus_MenuId",
                table: "Reservations");

            migrationBuilder.DropTable(
                name: "IngredientEntity");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Menus",
                table: "Menus");

            migrationBuilder.RenameTable(
                name: "Menus",
                newName: "MenuEntity");

            migrationBuilder.AddPrimaryKey(
                name: "PK_MenuEntity",
                table: "MenuEntity",
                column: "Id");

            migrationBuilder.CreateTable(
                name: "IngredientNameEntity",
                columns: table => new
                {
                    Ingredient = table.Column<string>(type: "TEXT", nullable: false),
                    MenuEntityId = table.Column<int>(type: "INTEGER", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_IngredientNameEntity", x => x.Ingredient);
                    table.ForeignKey(
                        name: "FK_IngredientNameEntity_MenuEntity_MenuEntityId",
                        column: x => x.MenuEntityId,
                        principalTable: "MenuEntity",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "IngredientToMenuMapperEntity",
                columns: table => new
                {
                    IngredientName = table.Column<string>(type: "TEXT", nullable: false),
                    MenuId = table.Column<int>(type: "INTEGER", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_IngredientToMenuMapperEntity", x => new { x.IngredientName, x.MenuId });
                });

            migrationBuilder.CreateIndex(
                name: "IX_IngredientNameEntity_MenuEntityId",
                table: "IngredientNameEntity",
                column: "MenuEntityId");

            migrationBuilder.AddForeignKey(
                name: "FK_Reservations_MenuEntity_MenuId",
                table: "Reservations",
                column: "MenuId",
                principalTable: "MenuEntity",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
