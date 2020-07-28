package com.iyengarcoders.groceries.mappers;


import com.iyengarcoders.groceries.dto.CartDto;
import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface CartMapper {

    @Mappings( {
            @Mapping(target = "cartId", source = "cart.id"),
            @Mapping(target = "cartItemsDto", source = "cart.cartItems"),
            @Mapping(target = "userProfileDto.username", source = "userProfile.username"),
            @Mapping(target = "userProfileDto.firstName", source = "userProfile.name.firstName"),
            @Mapping(target = "userProfileDto.lastName", source = "userProfile.name.lastName"),
            @Mapping(target = "userProfileDto.emailAddress", source = "userProfile.emailAddress"),
    })
    CartDto toCartDto(Cart cart, UserProfile userProfile);
}
