package com.serpens.spapi.domain.dao.user;

import com.serpens.spapi.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO extends JpaRepository<User, UUID> {
    User findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
}
