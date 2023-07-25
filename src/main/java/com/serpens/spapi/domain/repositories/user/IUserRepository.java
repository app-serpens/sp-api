package com.serpens.spapi.domain.repositories.user;

import com.serpens.spapi.domain.models.User;

public interface IUserRepository {
    User findByEmailAndPassword(String email, String password);
}
