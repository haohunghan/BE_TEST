package com.example.demo.common;

import com.example.demo.infrastructure.ServiceStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final String ERROR_MESSAGE = "There are some error when calling API";
    private final String BAD_REQUEST_MESSAGE = "Bad request!";

    // handling global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandling() {
        ErrorDetails errorDetails =
                new ErrorDetails(ServiceStatus.ERROR, ERROR_MESSAGE);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class,
            NumberFormatException.class})
    public ResponseEntity<?> badRequest() {
        ErrorDetails errorDetails =
                new ErrorDetails(ServiceStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
