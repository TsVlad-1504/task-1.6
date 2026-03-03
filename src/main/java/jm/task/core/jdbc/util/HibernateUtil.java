package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();

            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "Vlad1101.");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");

            cfg.addAnnotatedClass(User.class);

            return cfg.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Failed to build session factory.", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
