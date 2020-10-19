package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserService US = new UserServiceImpl();

        User u1 = new User("Artem", "Syrnik", (byte) 52);
        User u2 = new User("Kiril", "Kosoy", (byte) 33);
        User u3 = new User("Denis", "Stariy", (byte) 60);
        User u4 = new User("Misha", "Cherep", (byte) 20);

        US.createUsersTable();

        US.saveUser(u1.getName(), u1.getLastName(), u1.getAge());
        System.out.println("User с именем - " + u1.getName() + " добавлен в базу данных");
        US.saveUser(u2.getName(), u2.getLastName(), u2.getAge());
        System.out.println("User с именем - " + u2.getName() + " добавлен в базу данных");
        US.saveUser(u3.getName(), u3.getLastName(), u3.getAge());
        System.out.println("User с именем - " + u3.getName() + " добавлен в базу данных");
        US.saveUser(u4.getName(), u4.getLastName(), u4.getAge());
        System.out.println("User с именем - " + u4.getName() + " добавлен в базу данных");

        List<User> list =US.getAllUsers();
        for (User user : list){
            System.out.println(user);
        }
//
//        US.cleanUsersTable();
//        US.dropUsersTable();
    }
}
