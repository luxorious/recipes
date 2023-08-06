package com.recipes.controller.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class Handler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadAccountData(){
        log.error("bad value");
        return ResponseEntity.unprocessableEntity().build();
    }
}
