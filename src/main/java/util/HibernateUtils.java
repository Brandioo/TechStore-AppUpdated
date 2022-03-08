package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Computers.class);
                configuration.addAnnotatedClass(Cartel.class);
                configuration.addAnnotatedClass(CartelRecord.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Supplier.class);

                ServiceRegistry serviceRegistry = new
                        StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
