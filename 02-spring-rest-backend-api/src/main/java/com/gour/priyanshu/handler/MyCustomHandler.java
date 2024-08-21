package com.gour.priyanshu.handler;

import com.gour.priyanshu.exception.ErrorResponse;
import com.gour.priyanshu.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class MyCustomHandler {

    /*
     * 1. Handles the Exception
     * 2. Exception Type :: StudentNotFoundException
     * 3. Return Type    :: ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> showCustomErrorMsg(
            StudentNotFoundException snfe
    ){

        ErrorResponse body = new ErrorResponse(new Date().toString(),snfe.getMessage(),"500");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
