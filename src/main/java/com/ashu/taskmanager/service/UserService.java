package com.ashu.taskmanager.service;


import com.ashu.taskmanager.dto.LoginDTO;
import com.ashu.taskmanager.dto.UserSignUpDTO;
import com.ashu.taskmanager.model.User;

import java.util.Optional;

public interface UserService {
    public User signup(UserSignUpDTO dto);
    public User login(String email, String password);
}
