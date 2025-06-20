package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee e=new Employee();
        e.setId(2);
        e.setName("jagadeesh");
        e.setPhoneNumber(1234);

        Configuration config =new Configuration();
        config.addAnnotatedClass(org.example.Employee.class);
        config.configure("hiberante.cgf.xml");

        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();

        session.persist(e);


    }
}