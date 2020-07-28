package com.iyengarcoders.groceries.mappers;

import com.iyengarcoders.groceries.dto.ShippingAddressDto;
import com.iyengarcoders.groceries.entity.ShippingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ShippingAddressMapper {

    @Mappings({
            @Mapping(target = "addressId", source = "shippingAddress.id"),
            @Mapping(target = "line1", source = "shippingAddress.address.line1"),
            @Mapping(target = "line2", source = "shippingAddress.address.line2"),
            @Mapping(target = "city", source = "shippingAddress.address.city"),
            @Mapping(target = "state", source = "shippingAddress.address.state"),
            @Mapping(target = "country", source = "shippingAddress.address.country"),
            @Mapping(target = "zipCode", source = "shippingAddress.address.zipCode"),
            @Mapping(target = "lastUsed", source = "shippingAddress.address.lastUsed"),

    })
    ShippingAddressDto toShippingAddressDto(ShippingAddress shippingAddress);
}
