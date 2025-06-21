package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee e=new Employee();
        e.setId(1);
        e.setName("Jagadeesh Kalpana");
        e.setPhoneNumber(5678);

        Configuration config =new Configuration();
        config.addAnnotatedClass(org.example.Employee.class);
        config.configure("hiberante.cgf.xml");

        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();


          session.merge(e); // merge will use to update the existing data available in the table,
                           // if their no data with this id then merger will create a new data


        transaction.commit();

          factory.close();
          session.close();


    }
}
