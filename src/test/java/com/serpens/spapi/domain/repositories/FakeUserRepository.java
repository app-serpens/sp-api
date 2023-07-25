package com.serpens.spapi.domain.repositories;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.user.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeUserRepository implements IUserRepository {
    public List<User> users;

    public FakeUserRepository(List<User> users) {
        this.users = users;
    }

    public User findByEmailAndPassword(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
