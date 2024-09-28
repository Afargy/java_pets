package edu.school21.models;

public class User {
    private Long id;
    private String login;
    private String password;
    private Boolean authenticate;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        authenticate = false;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAuthenticate() {
        return authenticate;
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

    public void setAuthenticate(Boolean authenticate) {
        this.authenticate = authenticate;
    }

}
