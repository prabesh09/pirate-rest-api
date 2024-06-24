package com.pms.pirate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PirateNotFoundException extends RuntimeException {
    public PirateNotFoundException(String message) {
        super(message);
    }
}
