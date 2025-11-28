package com.ashu.taskmanager.exception;

import com.ashu.taskmanager.response.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req){
        String msg = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        System.out.println(req.getRequestURI());
        System.out.println(req.getRemoteAddr()+"\n"+req.getRemotePort()+"\n"+req.getRemoteHost()+"\n"+req.getRemoteUser());
        return ResponseEntity
                .badRequest()
                .body(new ApiError(msg));
    }
}


