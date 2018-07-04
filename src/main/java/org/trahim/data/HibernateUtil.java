package org.trahim.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.trahim.data.entity.User;

public class HibernateUtil {

//    for using hibernate properties
//    private static final SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(User.class);
//            return configuration
//                    .buildSessionFactory(new StandardServiceRegistryBuilder()
//                            .build());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("There was error building the session factory");
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

//for using hibernate xml configuration
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {

            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {

            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
