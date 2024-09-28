package edu.school21.service.repositories;

import java.util.Optional;

import edu.school21.service.models.User;

public interface UsersRepository extends CrudRepository<User> {
    public Optional<User> findByEmail(String email);
}
