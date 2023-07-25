package com.serpens.spapi.api.controllers;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.dao.user.UserDAO;
import com.serpens.spapi.domain.usecases.user.login.LoginInput;
import com.serpens.spapi.infra.repositories.user.UserRepository;
import com.serpens.spapi.domain.usecases.user.login.Login;
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
    private UserDAO userDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        Login usecase = new Login(new UserRepository(this.userDAO));
        user = usecase.call(new LoginInput(user.getEmail(), user.getPassword())).user();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
