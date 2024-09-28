package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> socializedRooms;

    public User(Long id, String login, String password,
            List<Chatroom> createdRooms, List<Chatroom> socilazedRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializedRooms = socilazedRooms;
    }

    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Chatroom> getCreatedRooms() {
        return this.createdRooms;
    }

    public List<Chatroom> getSocializedRooms() {
        return this.socializedRooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public void setSocializedRooms(List<Chatroom> socilizedRooms) {
        this.socializedRooms = socilizedRooms;
    }

    public void addCretedRoom(Chatroom room) {
        this.createdRooms.add(room);
    }

    public void addSocializedRoom(Chatroom room) {
        this.socializedRooms.add(room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, socializedRooms);
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
                User other = (User) obj;

                result = id.equals(other.id) && login.equals(other.login)
                        && password.equals(other.password)
                        && createdRooms.equals(other.createdRooms)
                        && socializedRooms.equals(other.socializedRooms);
            } catch (Exception e) {
                result = false;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", login=" + login + ", password=\"" + password
                + "\", createdRooms="
                + ((createdRooms != null) ? createdRooms.toString() : null)
                + ", socializedRooms="
                + ((socializedRooms != null) ? socializedRooms.toString()
                        : null)
                + "}";
    }

}
