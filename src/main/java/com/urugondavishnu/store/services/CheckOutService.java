package com.urugondavishnu.store.services;

import com.urugondavishnu.store.dtos.CheckOutRequest;
import com.urugondavishnu.store.dtos.CheckOutResponse;
import com.urugondavishnu.store.entities.Order;
import com.urugondavishnu.store.exceptions.CartEmptyException;
import com.urugondavishnu.store.exceptions.CartNotFoundException;
import com.urugondavishnu.store.repositories.CartRepository;
import com.urugondavishnu.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
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
