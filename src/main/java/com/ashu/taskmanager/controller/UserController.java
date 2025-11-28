package com.ashu.taskmanager.controller;

import com.ashu.taskmanager.dto.LoginDTO;
import com.ashu.taskmanager.dto.LoginResDTO;
import com.ashu.taskmanager.dto.UserSignUpDTO;
import com.ashu.taskmanager.dto.UserSignUpResDTO;
import com.ashu.taskmanager.model.User;
import com.ashu.taskmanager.response.ApiError;
import com.ashu.taskmanager.response.ApiResponse;
import com.ashu.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserSignUpResDTO>> signup(@Valid @RequestBody UserSignUpDTO dto){
            User user = userService.signup(dto);

            UserSignUpResDTO resDTO = new UserSignUpResDTO();

            resDTO.setName(user.getName());
            resDTO.setEmail(user.getEmail());

         ApiResponse<UserSignUpResDTO>  res = new ApiResponse<>(
                 "User Created Successfully!",
                 201,
                 resDTO
         );

//         return new ResponseEntity<>(res, HttpStatus.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
//            return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto){
        User user = userService.login(dto.getEmail(),dto.getPassword());

        if(user==null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiError("Invalid email or password"));
        }

        LoginResDTO resDTO = new LoginResDTO();
        resDTO.setEmail(user.getEmail());

        return ResponseEntity.ok(new ApiResponse<LoginResDTO>(
                "User LoggedIn successfully",
                201,
                resDTO
        ));
    }

}
