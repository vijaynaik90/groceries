package com.iyengarcoders.groceries.mappers;

import com.iyengarcoders.groceries.dto.ProductDto;
import com.iyengarcoders.groceries.entity.Product;
import com.iyengarcoders.groceries.utils.Constants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ProductMapper {

    @Mappings( {
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "product.unitOfMeasure", target = "unitOfMeasure", qualifiedByName = "enumToString"),
            @Mapping(source = "productCategory.id", target = "categoryDto.categoryId"),
            @Mapping(source = "productCategory.name", target = "categoryDto.categoryName"),


    })
    ProductDto productToProductDto(Product product);

    @Named("enumToString")
    public static String enumToString(Constants.UnitOfMeasure unitOfMeasure) {
        return unitOfMeasure.getValue();
    }
}
