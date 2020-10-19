package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=Europe/Moscow");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("show_sql", "true");
//        prop.setProperty("hibernate.default_schema", "users");
//        prop.setProperty("hibernate.hbm2ddl.auto", "create");

        Configuration configuration = new Configuration().addAnnotatedClass(User.class).addProperties(prop);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());


        sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;
    }
}
