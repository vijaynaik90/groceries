package com.iyengarcoders.groceries.mappers;


import com.iyengarcoders.groceries.dto.CartDto;
import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.CartItem;
import com.iyengarcoders.groceries.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface CartMapper {

    @Mappings( {
            @Mapping(target = "cartId", source = "cart.id"),
            @Mapping(target = "cartItemsDto", source = "cart.cartItems"),
            @Mapping(target = "userDto.userId", source = "user.id"),
            @Mapping(target = "userDto.userName", source = "user.username"),
            @Mapping(target = "userDto.firstName", source = "user.name.firstName"),
            @Mapping(target = "userDto.lastName", source = "user.name.lastName"),
            @Mapping(target = "userDto.emailAddress", source = "user.emailAddress"),
    })
    CartDto toCartDto(Cart cart, User user);
}
