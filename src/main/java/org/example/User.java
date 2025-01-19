package org.example;

public class User {
    public String login;
    public String password;
    public Role role;


    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
