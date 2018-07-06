package org.trahim.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.trahim.data.HibernateUtil;
import org.trahim.data.entity.Address;
import org.trahim.data.entity.Bank;
import org.trahim.data.entity.User;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            User user = new User();

            Address address = new Address();
            Address address2 = new Address();
            setAddressFields(address);
            setAddressFields2(address2);
            user.getAddress().add(address);
            user.getAddress().add(address2);
            setUserFields(user);

            session.save(user);
            transaction.commit();

            session.close();
            HibernateUtil.getSessionFactory().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setUserFields(User user) {
        user.setAge(22);
        user.setBirthDate(new Date());
        user.setCreatedBy("kmb");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385");
        user.setFirstName("Kevin");
        user.setLastName("bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
    }

    private static void setAddressFields(Address address) {
        address.setAddressLine1("Line 1");
        address.setAddressLine2("Line 2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
    }

    private static void setAddressFields2(Address address) {
        address.setAddressLine1("Line 3");
        address.setAddressLine2("Line 4");
        address.setCity("Corning");
        address.setState("NY");
        address.setZipCode("12345");
    }



}
