package com.serpens.spapi.domain.factories.user;

import com.serpens.spapi.domain.models.User;

import java.util.UUID;

public class UserFactory {
    public User createUser() {
        var user = new User();
        user.setEmail("email@email.com");
        user.setPassword("password");

        return user;
    }
}
