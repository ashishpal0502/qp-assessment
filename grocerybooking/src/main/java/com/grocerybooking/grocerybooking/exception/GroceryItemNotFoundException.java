package com.grocerybooking.grocerybooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GroceryItemNotFoundException extends RuntimeException{
    public GroceryItemNotFoundException(String message) {
        super(message);
    }
}
