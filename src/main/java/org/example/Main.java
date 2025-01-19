package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите логин или введите exit, чтобы завершить программу");
            String login = scanner.nextLine();

            if (login.equals("exit")) {
                System.out.println("Программа завершена!");
                break;
            }

            System.out.println("Введите пароль или введите exit, чтобы завершить программу");
            String password = scanner.nextLine();

            if (password.equals("exit")) {
                System.out.println("Программа завершена");
                break;
            }

            try {
                Role role = userCheck(login, password);

                if (role != null) {
                    menu(role);
                    break;
                }
            } catch (WrongLoginException e) {
                System.out.println("Логин не соответсвует требованиям");
            } catch (WrongPasswordException e) {
                System.out.println("Пароль не соответсвует требованиям");
            } catch (WrongPasswordOrLoginException e) {
                System.out.println("Неверный логин или пароль");
            }

        }
        scanner.close();

    }

    public static Role userCheck(String login, String password) throws WrongLoginException, WrongPasswordException, WrongPasswordOrLoginException {
        if (!CheckUser.checkLogin(login)) {
            throw new WrongLoginException();
        }

        if (!CheckUser.checkPassword(password)) {
            throw new WrongPasswordException();
        }

        if (CheckUser.checkPasAndLog(login, password) == null){
            throw new WrongPasswordOrLoginException();
        }
        return CheckUser.checkPasAndLog(login, password);
    }

    public static void menu(Role role) {
        switch (role) {
            case ADMIN:
                System.out.println("ADMIN");
                System.out.println("1.File");
                System.out.println("2.Create new user");
                System.out.println("3.Exit");
                break;

            case USER:
                System.out.println("USER");
                System.out.println("1.File");
                System.out.println("2.Get play list");
                System.out.println("3.Exit");
                break;
        }
    }
}