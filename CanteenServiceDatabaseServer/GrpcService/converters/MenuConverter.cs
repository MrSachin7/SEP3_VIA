using DTO;
using Google.Protobuf.Collections;
using grpcProtoFiles;

namespace GrpcService.converters; 

public class MenuConverter {

    public MenuDTO ToDto(Menu menu) {
        return new MenuDTO() {
            Id = menu.Id,
            Description = menu.Description,
            Ingredients = menu.Ingredients.ToList(),
            Name = menu.Name,
            Price = menu.Price
        };
    }

    public List<MenuDTO> ToDtoList(RepeatedField<Menu> menus) {
        return menus.Select(ToDto).ToList();
    }

    public Menu ToProto(MenuDTO menuDto) {
        Menu menu = new Menu() {
            Id = menuDto.Id,
            Description = menuDto.Description,
            Ingredients = {menuDto.Ingredients} ,
            Name = menuDto.Name,
            Price = menuDto.Price
        };

        return menu;    
    }

    public RepeatedField<Menu> ToProtoList(List<MenuDTO> menuDtos) {
        return new() {menuDtos.Select(ToProto).ToList()};
    }

}