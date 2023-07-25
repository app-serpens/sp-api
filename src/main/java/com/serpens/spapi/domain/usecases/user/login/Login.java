package com.serpens.spapi.domain.usecases.user.login;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.user.IUserRepository;

public class Login {
    final private IUserRepository userRepository;

    public Login(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginOutput call(LoginInput input) {
        final User user = this.userRepository.findByEmailAndPassword(input.email(), input.password());
        return new LoginOutput(user);
    }
}
