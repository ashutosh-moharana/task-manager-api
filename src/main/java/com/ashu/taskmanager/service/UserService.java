package com.ashu.taskmanager.service;


import com.ashu.taskmanager.dto.UserSignUpDTO;
import com.ashu.taskmanager.model.User;

public interface UserService {
    public User signup(UserSignUpDTO dto);
}
