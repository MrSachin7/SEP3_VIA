using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace EFC.Migrations
{
    /// <inheritdoc />
    public partial class addOneToMany : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_IngredientEntity_Menus_MenuEntityId",
                table: "IngredientEntity");

            migrationBuilder.DropPrimaryKey(
                name: "PK_IngredientEntity",
                table: "IngredientEntity");

            migrationBuilder.DropIndex(
                name: "IX_IngredientEntity_MenuEntityId",
                table: "IngredientEntity");

            migrationBuilder.DropColumn(
                name: "MenuEntityId",
                table: "IngredientEntity");

            migrationBuilder.RenameTable(
                name: "IngredientEntity",
                newName: "Ingredients");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Ingredients",
                table: "Ingredients",
                column: "IngredientName");

            migrationBuilder.CreateTable(
                name: "MenuIngredientEntity",
                columns: table => new
                {
                    MenuId = table.Column<int>(type: "INTEGER", nullable: false),
                    IngredientName = table.Column<string>(type: "TEXT", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_MenuIngredientEntity", x => new { x.MenuId, x.IngredientName });
                    table.ForeignKey(
                        name: "FK_MenuIngredientEntity_Ingredients_IngredientName",
                        column: x => x.IngredientName,
                        principalTable: "Ingredients",
                        principalColumn: "IngredientName",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_MenuIngredientEntity_Menus_MenuId",
                        column: x => x.MenuId,
                        principalTable: "Menus",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_MenuIngredientEntity_IngredientName",
                table: "MenuIngredientEntity",
                column: "IngredientName");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "MenuIngredientEntity");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Ingredients",
                table: "Ingredients");

            migrationBuilder.RenameTable(
                name: "Ingredients",
                newName: "IngredientEntity");

            migrationBuilder.AddColumn<int>(
                name: "MenuEntityId",
                table: "IngredientEntity",
                type: "INTEGER",
                nullable: true);

            migrationBuilder.AddPrimaryKey(
                name: "PK_IngredientEntity",
                table: "IngredientEntity",
                column: "IngredientName");

            migrationBuilder.CreateIndex(
                name: "IX_IngredientEntity_MenuEntityId",
                table: "IngredientEntity",
                column: "MenuEntityId");

            migrationBuilder.AddForeignKey(
                name: "FK_IngredientEntity_Menus_MenuEntityId",
                table: "IngredientEntity",
                column: "MenuEntityId",
                principalTable: "Menus",
                principalColumn: "Id");
        }
    }
}
