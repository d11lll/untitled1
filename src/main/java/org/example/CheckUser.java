package org.example;

public class CheckUser {
    static User admin = new User("dalilya2417@icloud.com", "Dalilya2006!", Role.ADMIN);
    static User user = new User("user2005@gmail.com", "Privet_123", Role.USER);

    public static boolean checkLogin(String login) {
        return login.length() >= 20 && login.matches("[a-zA-Z0-9@._-]+");
    }

    public static boolean checkPassword(String password) {
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[{}\\[\\](),.;&?!_\\-+]).{8,}$");
    }

    public static Role checkPasAndLog(String login, String password) {
        if (login.equals(admin.login) && password.equals(admin.password)) {
            return admin.role;
        } else if (login.equals(user.login) && password.equals(user.password)) {
            return user.role;
        } else {
            return null;
        }
    }
}
