package com.ashokit.exceptions;

import com.ashokit.payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> handler(ResourceNotFoundException exception){

        String message = exception.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return  new ResponseEntity<>(apiResponce, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validateExceptionHandler(MethodArgumentNotValidException exception){

        Map<String,String> responce=new HashMap<>();

        exception.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String defaultMessage = objectError.getDefaultMessage();
                    responce.put(fieldName,defaultMessage);
                });
        return new ResponseEntity<>(responce,HttpStatus.BAD_REQUEST);
    }
}
