package edu.school21.chat.repositories;

import java.util.Optional;

import edu.school21.chat.models.Message;

public interface MessagesRepository {
    public Optional<Message> findById(Long id);
}
