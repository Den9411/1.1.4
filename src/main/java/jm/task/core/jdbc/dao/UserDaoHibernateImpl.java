package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory;


    public UserDaoHibernateImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (id  INT auto_increment, firstname VARCHAR (45), " +
                "lastname VARCHAR (45), age INT, primary key (id));";
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        String sql = "drop table if exists users";
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(new User(name, lastName, age));
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        String sql = "delete from users where id=" + id + "";

        HibernateUtil.getSessionFactory().openSession().createSQLQuery(sql);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) HibernateUtil.getSessionFactory()
                .openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        dropUsersTable();
        createUsersTable();
    }
}
