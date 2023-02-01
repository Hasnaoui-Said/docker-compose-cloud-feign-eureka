package org.product.gp.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApiOrderException extends Exception {
    public ApiOrderException(String message) {
        super(message);
    }
}

