package com.urugondavishnu.store.mappers;

import com.urugondavishnu.store.dtos.ProductDto;
import com.urugondavishnu.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    Product toEnitity(ProductDto request);

    @Mapping(target="id", ignore = true)
    void update(ProductDto request,@MappingTarget Product product);
}
