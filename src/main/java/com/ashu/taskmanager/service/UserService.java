package com.ashu.taskmanager.service;


import com.ashu.taskmanager.dto.AuthDTOs;
import com.ashu.taskmanager.model.User;

public interface UserService {
    User signup(AuthDTOs.SignUpReq dto);
    User login(AuthDTOs.LoginReq dto);
}
