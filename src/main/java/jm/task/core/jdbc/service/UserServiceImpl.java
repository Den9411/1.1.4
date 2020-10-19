package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
//    private UserDao dao = new UserDaoJDBCImpl();
    private UserDao hibDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        hibDao.createUsersTable();
    }

    public void dropUsersTable() {
        hibDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        hibDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        hibDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return hibDao.getAllUsers();
    }

    public void cleanUsersTable() {
        hibDao.cleanUsersTable();
    }
}
