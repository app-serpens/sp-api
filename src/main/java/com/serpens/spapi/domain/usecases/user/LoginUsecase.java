package com.serpens.spapi.domain.usecases.user;

import com.serpens.spapi.domain.models.User;
import com.serpens.spapi.domain.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class LoginUsecase {
    final private IUserRepository userRepository;

    @AllArgsConstructor
    public static class LoginUsecaseInput {
        private String email;
        private String password;
    }

    @AllArgsConstructor
    public static class LoginUsecaseOutput {
        @Getter
        private User user;
    }

    public LoginUsecase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginUsecaseOutput login(LoginUsecaseInput input) {
        final User user = this.userRepository.findByEmailAndPassword(input.email, input.password);
        return new LoginUsecaseOutput(
                user
        );
    }
}
