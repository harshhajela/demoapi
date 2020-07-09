package com.example.demoapi.exceptions;

import com.example.demoapi.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PlayerNotFound.class)
    public final ResponseEntity<Object> handleInventoryNotFound(Exception ex, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                "Required ID not found in system! Please provide correct ID value.",
                HttpStatus.NOT_FOUND.value());
        //errorDetails.getErrors().put("id", ex.getMessage());
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
}
