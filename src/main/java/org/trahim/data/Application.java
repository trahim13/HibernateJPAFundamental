package org.trahim.data;

import org.hibernate.Session;
import org.trahim.data.HibernateUtil;
import org.trahim.data.entity.Address;
import org.trahim.data.entity.Bank;
import org.trahim.data.entity.User;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("TRAHIM");
        user.setLastName("MMM");
        user.setEmailAddress("email@Mail.com");
        user.setCreatedDate(new Date());
        user.setBirthDate(new Date());
        user.setAge(26);
        user.setCreatedBy("eee");
        user.setFirstName("ddd");

        Address address = new Address();
        address.setAddressLine1("Line 1");
        address.setAddressLine2("Line 2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
        user.setAddress(address);

        session.save(user);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
