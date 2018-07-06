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
        Bank bank = new Bank();
        bank.setName("Federal great Trust");

        bank.setInternational(false);
        bank.setCreatedBy("Kevin");
        bank.setCreatedDate(new Date());
        bank.setLastUpdatedBy("Kevin");
        bank.setLastUpdatedDate(new Date());

        bank.getMapContacts().put("MANAGER", "Lui");
        bank.getMapContacts().put("SELLER", "Andry");

        Address address = new Address();
        address.setAddressLine1("Line 2");
        address.setAddressLine2("Line 3");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
        bank.setAddress(address);

        session.save(bank);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
