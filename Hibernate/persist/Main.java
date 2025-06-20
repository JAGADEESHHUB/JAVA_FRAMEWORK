package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Employee e=new Employee();
        e.setId(1);
        e.setName("kalpana");
        e.setPhoneNumber(5678);

        Configuration config =new Configuration();
        config.addAnnotatedClass(org.example.Employee.class);
        config.configure("hiberante.cgf.xml");

        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(e);

        transaction.commit();

        factory.close();
        session.close();


    }
}
