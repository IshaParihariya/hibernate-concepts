package com.isha.app;

import com.isha.model.StudentDetailForWithoutXML;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WithoutXMLConfig
{
    public static void main(String[] args)
    {
        Configuration config=new Configuration();
        // spaces in between the configuration breaks the config.
        config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernetapp");
        config.setProperty("hibernate.connection.username","root");
        config.setProperty("hibernate.connection.password","Lovealarm@123");
        config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.show_sql","true");
        config.setProperty("hibernate.format_sql","true");
        config.setProperty("hibernate.hbm2ddl.auto","create");

        //entity mapping
        config.addAnnotatedClass(StudentDetailForWithoutXML.class);

        SessionFactory sessionFactory= config.buildSessionFactory();

           Session session=sessionFactory.openSession();
           Transaction transaction=session.beginTransaction();
            StudentDetailForWithoutXML sd=new StudentDetailForWithoutXML();
            sd.setSid(1);
            sd.setSname("Cupcake");
            sd.setSemail("abc@gmail.com");
            sd.setScity("Bengaluru");
            System.out.println(sd);
            // saving
            session.persist(sd);

        transaction.commit();


        session.close();
            sessionFactory.close();

    }
}

