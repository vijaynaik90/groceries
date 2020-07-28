package com.iyengarcoders.groceries.mappers;


import com.iyengarcoders.groceries.dto.CartItemDto;
import com.iyengarcoders.groceries.dto.ProductDto;
import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.CartItem;
import com.iyengarcoders.groceries.utils.Constants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartItemMapper {

    @Mappings({
            @Mapping(target = "itemId", source = "cartItem.id"),
            @Mapping(target = "productDto", source = "cartItem.product")

    })
    CartItemDto toCartItemDto(CartItem cartItem);
}
