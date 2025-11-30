package com.ashu.taskmanager.service;

import com.ashu.taskmanager.dto.AuthDTOs;
import com.ashu.taskmanager.exception.BadCredentialsException;
import com.ashu.taskmanager.model.User;
import com.ashu.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    public User signup(AuthDTOs.SignUpReq dto){

        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new BadCredentialsException("User Already Exists!");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return userRepository.save(user);
    }

    @Override
    public User login(AuthDTOs.LoginReq dto){
       User user = userRepository
                    .findByEmail(dto.email())
                    .orElseThrow(()-> new BadCredentialsException("User Not Found"));

       if(!user.getPassword().equals(dto.password())){
          throw new BadCredentialsException("Wrong Password");
       }

       return user;
    }

}
