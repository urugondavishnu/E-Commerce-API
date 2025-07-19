package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.CheckOutRequest;
import com.codewithmosh.store.dtos.CheckOutResponse;
import com.codewithmosh.store.dtos.ErrorDto;
import com.codewithmosh.store.entities.Order;
import com.codewithmosh.store.entities.OrderItem;
import com.codewithmosh.store.entities.OrderStatus;
import com.codewithmosh.store.exceptions.CartEmptyException;
import com.codewithmosh.store.exceptions.CartNotFoundException;
import com.codewithmosh.store.repositories.CartRepository;
import com.codewithmosh.store.repositories.OrderRepository;
import com.codewithmosh.store.services.AuthService;
import com.codewithmosh.store.services.CartService;
import com.codewithmosh.store.services.CheckOutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckOutController {
    private final CheckOutService checkOutService;
    private final CartRepository cartRepository;
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    @PostMapping
    public CheckOutResponse  checkout(
            @Valid @RequestBody CheckOutRequest request
    ){
        var response = checkOutService.checkout(request);
        return response;
    }

    @ExceptionHandler({CartNotFoundException.class, CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception e){
        return ResponseEntity.badRequest().body(
               new ErrorDto(e.getMessage())
        );
    }
}
