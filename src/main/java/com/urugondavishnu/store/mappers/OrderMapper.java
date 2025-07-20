package com.urugondavishnu.store.mappers;

import com.urugondavishnu.store.dtos.OrderDto;
import com.urugondavishnu.store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
