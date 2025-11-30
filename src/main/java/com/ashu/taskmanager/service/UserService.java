package com.ashu.taskmanager.service;


import com.ashu.taskmanager.dto.AuthDTOs;
import com.ashu.taskmanager.model.User;

public interface UserService {
    public User signup(AuthDTOs.SignUpReq dto);
    public User login(AuthDTOs.LoginReq dto);
}
