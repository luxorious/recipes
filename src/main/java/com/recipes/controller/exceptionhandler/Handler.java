package com.recipes.controller.exceptionhandler;

import com.recipes.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransactionException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class Handler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleBadAccountData(ValidationException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleBadAccountData(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> handleBadAccountData(FileNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleBadAccountData(NoSuchElementException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<String> handleBadAccountData(IllegalAccessException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(InvocationTargetException.class)
    public ResponseEntity<String> handleBadAccountData(InvocationTargetException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleBadAccountData(MultipartException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleBadAccountData(DataIntegrityViolationException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleBadAccountData(NullPointerException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleBadAccountData(DataAccessException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<String> handleBadAccountData(TransactionException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<String> handleBadAccountData(InvalidDataAccessApiUsageException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException(
            SQLIntegrityConstraintViolationException exception) {
        log.error(exception.getMessage());
        return exception.getMessage();
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
