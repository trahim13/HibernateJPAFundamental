package org.trahim.data;

import org.hibernate.Session;
import org.trahim.data.HibernateUtil;
import org.trahim.data.entity.User;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setBirthDate(getBirthDate());
        user.setCreatedBy("trahim");
        user.setCreatedDate(new Date());
        user.setEmailAddress("same@same.com");
        user.setFirstName("trahim");
        user.setLastName("Val");
        user.setLastUpdatedBy("TRAHIM");
        user.setLastUpdatedDate(new Date());

        session.save(user);

        session.getTransaction().commit();
        session.refresh(user);
        System.out.println(user.getAge());
        session.close();
        HibernateUtil.getSessionFactory().close();
    }

    private static Date getBirthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1992);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 13);
        return calendar.getTime();

    }
}
