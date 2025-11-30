package com.ashu.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthDTOs {

    //Login Request DTO
    public record LoginReq(
            @Email(message = "Email is not valid") String email,
            @NotBlank(message = "Password is required") String password
    ){}

    //Login Response DTO
    public record LoginRes(
            String email
    ){}


    //SignUp Request DTO
    public record SignUpReq(
    @NotBlank(message = "Name is Required")
    String name,

    @Email(message = "Email is Required")
    String email,

    @NotBlank(message = "Password is Required")
    String password

    ){}

    //SignUp Response DTO
    public record SignUpRes(
            String name,
            String email
    ){}
}
