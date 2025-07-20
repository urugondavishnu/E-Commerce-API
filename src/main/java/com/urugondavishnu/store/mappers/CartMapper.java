package com.urugondavishnu.store.mappers;

import com.urugondavishnu.store.dtos.CartDto;
import com.urugondavishnu.store.dtos.CartItemDto;
import com.urugondavishnu.store.entities.Cart;
import com.urugondavishnu.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "items", source ="cartItems")
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target ="totalPrice" , expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
