package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UserRepository;

public class UsersServiceImpl {
    private UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String login, String password)
            throws AlreadyAuthenticatedException {
        boolean authenticationResult = false;
        User user = userRepository.findByLogin(login);

        if (user.getAuthenticate().equals(true)) {
            throw new AlreadyAuthenticatedException();
        }

        if (password.equals(user.getPassword())) {
            user.setAuthenticate(true);
            userRepository.update(user);
            authenticationResult = true;
        }

        return authenticationResult;
    }
}
