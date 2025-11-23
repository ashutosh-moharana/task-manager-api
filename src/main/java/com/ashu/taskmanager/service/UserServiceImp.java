package com.ashu.taskmanager.service;

import com.ashu.taskmanager.dto.UserSignUpDTO;
import com.ashu.taskmanager.model.User;
import com.ashu.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    public User signup(UserSignUpDTO dto){
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }
}
