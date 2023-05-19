using DTO;
using grpcProtoFiles;

namespace GrpcService.converters; 

public class MenuConverter {

    public MenuDTO ToDTO(Menu menu) {
        return new MenuDTO() {
            Id = menu.Id,
            Description = menu.Description,
            Ingredients = AbstractConverter.ToList<String>(menu.Ingredients),
            Name = menu.Name,
            Price = menu.Price
        };
    }

    public Menu ToProto(MenuDTO menuDto) {
        Menu menu = new Menu() {
            Id = menuDto.Id,
            Description = menuDto.Description,
            Name = menuDto.Name,
            Price = menuDto.Price
        };
        // Cant use the abstract converter because of the private setter.
        menu.Ingredients.AddRange(menuDto.Ingredients);
        return menu;
    }
    
}