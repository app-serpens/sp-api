package com.serpens.spapi.api.controllers;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.IUserRepository;
import com.serpens.spapi.domain.usecases.user.LoginUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        LoginUsecase usecase = new LoginUsecase(userRepository);
        user = usecase.login(new LoginUsecase.LoginUsecaseInput(user.getEmail(), user.getPassword())).getUser();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
