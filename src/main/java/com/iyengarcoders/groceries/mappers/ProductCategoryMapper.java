package com.iyengarcoders.groceries.mappers;

import com.iyengarcoders.groceries.dto.ProductCategoryDto;
import com.iyengarcoders.groceries.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    @Mappings( {
            @Mapping(target = "categoryId", source = "productCategory.id"),
            @Mapping(target = "categoryName",source = "productCategory.name")
    })
    ProductCategoryDto toProductCategoryDto(ProductCategory productCategory);
}
