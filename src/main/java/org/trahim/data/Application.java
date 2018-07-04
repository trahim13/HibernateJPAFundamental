package org.trahim.data;

import org.hibernate.Session;
import org.trahim.data.HibernateUtil;
import org.trahim.data.entity.User;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("trahim");
        user.setCreatedDate(new Date());
        user.setEmailAddress("same@same.com");
        user.setFirstName("trahim");
        user.setLastName("Val");
        user.setLastUpdatedBy("TRAHIM");
        user.setLastUpdatedDate(new Date());

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
