package com.serpens.spapi.infra.repositories.user;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.user.IUserRepository;
import com.serpens.spapi.domain.dao.user.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    private final UserDAO userDAO;

    public UserRepository(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findByEmailAndPassword(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    }
}
