package com.ashu.taskmanager.exception;

import com.ashu.taskmanager.response.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Handles Validation Error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex){
        String msg = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(new ApiError(msg));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity<ApiError> handleSignupError(UserAlreadyExistsException ex) {
        System.out.println("SignUp Failed: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(ex.getMessage()));
    }


    //Handles Login Error
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleLoginError(BadCredentialsException ex){
        System.out.println("Login Failed: "+ ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiError(ex.getMessage()));
    }



}


