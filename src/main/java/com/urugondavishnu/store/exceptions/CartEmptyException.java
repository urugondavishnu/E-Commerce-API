package com.urugondavishnu.store.exceptions;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException(){
        super("Cart is Empty");
    }
}
