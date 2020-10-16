package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try  {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id  INT auto_increment, firstname VARCHAR (45), " +
                    "lastname VARCHAR (45), age INT, primary key (id));");
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try  {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("drop TABLE if exists users");
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try  {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into users (firstname, lastname, age) values ('" + name
                    + "', '" + lastName + "', " + age + ")");
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try  {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from users where id=" + id + "");
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try  {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                String lastname = rs.getString(3);
                byte age = rs.getByte(4);
                User user = new User(name, lastname, age);
                user.setId(id);
                userList.add(user);
            }
            rs.close();
            stmt.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        dropUsersTable();
        createUsersTable();
    }
}
