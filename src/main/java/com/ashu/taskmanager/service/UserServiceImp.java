package com.ashu.taskmanager.service;

import com.ashu.taskmanager.dto.LoginDTO;
import com.ashu.taskmanager.dto.UserSignUpDTO;
import com.ashu.taskmanager.model.User;
import com.ashu.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public User login(String email,String password){
       Optional<User> userOpt = userRepository.findByEmail(email);

       if(userOpt.isEmpty()){
          return null;
       }

       User user = userOpt.get();
       if(!user.getPassword().equals(password)){
           return null;
       }
       return user;
    }

}
