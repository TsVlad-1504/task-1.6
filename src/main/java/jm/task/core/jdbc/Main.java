package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        System.out.println("Пользователь с именем - Ivan добавлен в базу данных");

        userService.saveUser("Anna", "Petrova", (byte) 30);
        System.out.println("Пользователь с именем - Anna добавлен в базу данных");

        userService.saveUser("Petr", "Sidorov", (byte) 28);
        System.out.println("Пользователь с именем - Petr добавлен в базу данных");

        userService.saveUser("Maria", "Smirnova", (byte) 22);
        System.out.println("Пользователь с именем - Maria добавлен в базу данных");

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
