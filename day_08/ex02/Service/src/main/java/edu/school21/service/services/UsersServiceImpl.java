package edu.school21.service.services;

import org.springframework.beans.factory.annotation.Autowired;

import edu.school21.service.models.User;
import edu.school21.service.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public String signUp(String email) {
        usersRepository.save(new User(null, email));
        return email + "1234";
    }

}
