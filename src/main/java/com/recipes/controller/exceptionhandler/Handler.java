package com.recipes.controller.exceptionhandler;

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
    //NoSuchElementException
    //IllegalAccessException | InvocationTargetException
    //IllegalArgumentException
    //NullPointerExeption: Якщо repository є нульовим (null), буде спричинена помилка NullPointerException.
    //IllegalArgumentException: Якщо передані параметри name або instruction є null, це може спричинити виникнення помилки IllegalArgumentException.
    //DataAccessException: Якщо є проблеми з підключенням до бази даних або запит не вдалося виконати через проблеми з базою даних, це може призвести до помилки DataAccessException або його підкласів.
    //TransactionException: Якщо цей метод знаходиться в межах транзакції і виникає проблема під час збереження даних в базі даних, це може призвести до помилки TransactionException.
    //InvalidDataAccessApiUsageException: Якщо метод оновлення в репозиторії не був налаштований або викликався з недійсними параметрами, це може призвести до помилки InvalidDataAccessApiUsageException.
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
