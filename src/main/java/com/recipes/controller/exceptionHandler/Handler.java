package com.recipes.controller.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class Handler {
    @Value(value = "${exceptions.handleSQLIntegrityConstraintViolationException}")
    private String messageHandleSQLIntegrityConstraintViolationException;
    //SQLIntegrityConstraintViolationException - duplicate data in db
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadAccountData() {
        log.error("bad value");
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException() {
        log.error("file not found!");
        return ResponseEntity.unprocessableEntity().build();
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException(
            SQLIntegrityConstraintViolationException exception) {
        log.error("bad value! " + exception.getMessage());
        return messageHandleSQLIntegrityConstraintViolationException;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorDescribe = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    String name = error.getField();
                    String problemDescription = error.getDefaultMessage();
                    errorDescribe.put(name, problemDescription);
                });
        return errorDescribe;
    }
}
