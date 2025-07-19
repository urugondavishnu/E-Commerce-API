package com.codewithmosh.store.services;

import com.codewithmosh.store.dtos.CheckOutRequest;
import com.codewithmosh.store.dtos.CheckOutResponse;
import com.codewithmosh.store.dtos.ErrorDto;
import com.codewithmosh.store.entities.Order;
import com.codewithmosh.store.exceptions.CartEmptyException;
import com.codewithmosh.store.exceptions.CartNotFoundException;
import com.codewithmosh.store.repositories.CartRepository;
import com.codewithmosh.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CheckOutService {

    private final CartRepository cartRepository;
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public CheckOutResponse checkout(CheckOutRequest request){
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);

        if(cart==null){
            throw new CartNotFoundException();
        }

        if(cart.isEmpty()){
            throw new CartEmptyException();
        }

        var order = Order.fromCart(cart, authService.getCurrentUser());
        orderRepository.save(order);

        cartService.clearCart(cart.getId());

        return new CheckOutResponse(order.getId());
    }
}
