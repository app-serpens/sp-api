package com.serpens.spapi.domain.repositories;

import com.serpens.spapi.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByEmailAndPassword(String email, String password);
}
