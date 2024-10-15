package com.wiktoria.controller;

import com.wiktoria.model.User;
import com.wiktoria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user){
        User newdUser = new User();
        newdUser.setEmail(user.getEmail());
        newdUser.setPassword(user.getPassword());
        newdUser.setEmail(user.getEmail());
        newdUser.setFullName(user.getFullName());

        User saveduser = userRepository.save(newdUser);


        return new ResponseEntity<>(saveduser, HttpStatus.CREATED) ;
        //created bc I will create new user here


    }
}
