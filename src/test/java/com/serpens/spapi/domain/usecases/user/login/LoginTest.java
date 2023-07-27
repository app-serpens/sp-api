package com.serpens.spapi.domain.usecases.user.login;

import com.serpens.spapi.domain.factories.user.UserFactory;
import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.FakeUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    public FakeUserRepository userRepository;

    @BeforeEach
    public void setUp() {
       this.userRepository = new FakeUserRepository(new ArrayList<>());
    }

    @AfterEach
    public void tearDown() {
        this.userRepository = null;
    }

    @Test
    @DisplayName("Should return user1 logged in")
    public void testLogin() {
        var userFactory = new UserFactory();

        var user1 = userFactory.createUser();
        user1.setEmail("email1@email.com");
        user1.setId(UUID.randomUUID());
        this.userRepository.users.add(user1);

        var user2 = userFactory.createUser();
        user2.setEmail("email2@email.com");
        user2.setId(UUID.randomUUID());
        this.userRepository.users.add(user2);

        var usecase = new Login(userRepository);
        var input = new LoginInput("email1@email.com", "password");
        var output = usecase.call(input);

        assertEquals(user1.getId(), output.user().getId());
        assertEquals(user1.getEmail(), output.user().getEmail());
        assertEquals(user1.getPassword(), output.user().getPassword());
    }
}
