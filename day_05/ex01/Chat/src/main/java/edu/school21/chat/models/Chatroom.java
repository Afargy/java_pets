package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> messages;

    public Chatroom(Long id, String name, User owner, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public User getOwner() {
        return this.owner;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, messages);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            result = false;
        } else if (obj == this) {
            result = true;
        } else {
            try {
                Chatroom other = (Chatroom) obj;

                result = id.equals(other.id) && name.equals(other.name)
                        && owner.equals(other.owner)
                        && messages.equals(other.messages);
            } catch (Exception e) {
                result = false;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", name=" + name + ", owner=" + owner
                + ", messages="
                + ((messages != null) ? messages.toString() : null) + "}";
    }

}
