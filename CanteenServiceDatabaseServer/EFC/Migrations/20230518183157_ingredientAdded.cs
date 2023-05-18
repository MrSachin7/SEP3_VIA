using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace EFC.Migrations
{
    /// <inheritdoc />
    public partial class ingredientAdded : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "IngredientEntity");

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
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "IngredientNameEntity");

            migrationBuilder.DropTable(
                name: "IngredientToMenuMapperEntity");

            migrationBuilder.CreateTable(
                name: "IngredientEntity",
                columns: table => new
                {
                    Ingredient = table.Column<string>(type: "TEXT", nullable: false),
                    MenuEntityId = table.Column<int>(type: "INTEGER", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_IngredientEntity", x => x.Ingredient);
                    table.ForeignKey(
                        name: "FK_IngredientEntity_MenuEntity_MenuEntityId",
                        column: x => x.MenuEntityId,
                        principalTable: "MenuEntity",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateIndex(
                name: "IX_IngredientEntity_MenuEntityId",
                table: "IngredientEntity",
                column: "MenuEntityId");
        }
    }
}
