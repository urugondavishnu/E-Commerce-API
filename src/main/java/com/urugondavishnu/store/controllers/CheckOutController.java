package com.urugondavishnu.store.controllers;

import com.urugondavishnu.store.dtos.CheckOutRequest;
import com.urugondavishnu.store.dtos.CheckOutResponse;
import com.urugondavishnu.store.dtos.ErrorDto;
import com.urugondavishnu.store.exceptions.CartEmptyException;
import com.urugondavishnu.store.exceptions.CartNotFoundException;
import com.urugondavishnu.store.repositories.CartRepository;
import com.urugondavishnu.store.repositories.OrderRepository;
import com.urugondavishnu.store.services.AuthService;
import com.urugondavishnu.store.services.CartService;
import com.urugondavishnu.store.services.CheckOutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public CheckOutResponse checkout(
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
