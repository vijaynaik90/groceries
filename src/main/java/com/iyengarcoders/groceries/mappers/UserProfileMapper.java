package com.iyengarcoders.groceries.mappers;

import com.iyengarcoders.groceries.dto.UserProfileDto;
import com.iyengarcoders.groceries.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ShippingAddressMapper.class})
public interface UserProfileMapper {
    @Mappings({
            @Mapping(target = "username", source = "userProfile.username"),
            @Mapping(target = "firstName", source = "userProfile.name.firstName"),
            @Mapping(target = "middleName", source = "userProfile.name.middleName"),
            @Mapping(target = "lastName", source = "userProfile.name.lastName"),
            @Mapping(target = "cellPhone", source = "userProfile.cellPhone"),
            @Mapping(target = "homePhone", source = "userProfile.homePhone"),
            @Mapping(target = "emailAddress", source = "userProfile.emailAddress"),
            @Mapping(target = "shippingAddresses", source = "userProfile.shippingAddresses"),

    })
    UserProfileDto toUserDto(UserProfile userProfile);
}
