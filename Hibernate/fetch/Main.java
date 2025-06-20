package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//
//        Employee e=new Employee();
//        e.setId(1);
//        e.setName("kalpana");
//        e.setPhoneNumber(5678);

        Configuration config =new Configuration();
        config.addAnnotatedClass(org.example.Employee.class);
        config.configure("hiberante.cgf.xml");

        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();

//        Transaction transaction = session.beginTransaction(); //for fetching data we don't need transaction

//        Employee e1 = session.byId(Employee.class).load(1); // lazy fetching (this for if we are not sure that, we are going to use that object means,
                                                             // we can use lazy fetch because why we need to waste a call like that it will work.

          Employee e1 = session.find(Employee.class, 1); //eager fetching

          System.out.println(e1);


//        transaction.commit();

          factory.close();
          session.close();


    }
}
