package edu.school21.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.exceptions.EntityNotFoundException;
import edu.school21.models.User;
import edu.school21.repositories.UserRepository;

class UsersServiceImplTest {
    private UserRepository userRepositoryMock;
    private UsersServiceImpl usersServiceImpl;

    @BeforeEach
    void init() {
        userRepositoryMock = mock(UserRepository.class);
        usersServiceImpl = new UsersServiceImpl(userRepositoryMock);
    }

    @Test
    void test_authenticate_correctLoginAndPassword() {
        User user = new User(1L, "user", "password");

        when(userRepositoryMock.findByLogin("user")).thenReturn(user);
        assertTrue(usersServiceImpl.authenticate("user", "password"));
    }

    @Test
    void test_authenticate_wrongPassword() {
        User user = new User(1L, "user", "password");

        when(userRepositoryMock.findByLogin("user")).thenReturn(user);
        assertFalse(usersServiceImpl.authenticate("user", "wrongPassword"));
    }

    @Test
    void test_authenticate_wrongLogin() {
        when(userRepositoryMock.findByLogin("user"))
                .thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class,
                () -> usersServiceImpl.authenticate("user", "password"));
    }

    @Test
    void test_authenticate_alreadyAuthenricated() {
        User user = new User(1L, "user", "password");

        user.setAuthenticate(true);
        when(userRepositoryMock.findByLogin("user")).thenReturn(user);
        assertThrows(AlreadyAuthenticatedException.class,
                () -> usersServiceImpl.authenticate("user", "password"));
    }

}
