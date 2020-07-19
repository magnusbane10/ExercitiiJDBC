package Util;

import com.sun.security.ntlm.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/cinemasystem");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "aa753698+*");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
    /*
    Automatically validates or exports schema DDL to the database when the SessionFactory is created.
    With create-drop, the database schema will be dropped when the SessionFactory is closed explicitly.
    - validate: validate the schema, makes no changes to the database.
    - update: update the schema.
    - create: creates the schema, destroying previous data.
    - create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
    - none: does nothing with the schema, makes no changes to the database
     */
                settings.put(Environment.HBM2DDL_AUTO, "none");
                configuration.setProperties(settings);
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Movie.class);
                configuration.addAnnotatedClass(Rezervation.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(Schedule.class);
                configuration.addAnnotatedClass(Seat.class);
                configuration.addAnnotatedClass(TicketCategories.class);
                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                sessionFactory.openSession();
            } catch (Exception e) {
                throw new RuntimeException("Failed to open session", e);
            }
        }
        return sessionFactory;
    }
    public static void shutDownFactory(){
        getSessionFactory().close();
    }
}

