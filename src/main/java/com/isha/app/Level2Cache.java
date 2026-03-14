package com.isha.app;

import com.isha.model.StudentDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Level2Cache
{
    // data cache scope : session factory
    // multiple sessions will share the same data
    public static void main(String[] args)
    {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1=null;
        Session session2=null;
        Transaction transaction=null;
        boolean flag=false;

        try
        {
            // session1
            session1=sessionFactory.openSession();
            transaction=session1.beginTransaction();
            StudentDetail sd=session1.get(StudentDetail.class,1);
            System.out.println(sd);
            StudentDetail sd1=session1.get(StudentDetail.class,1);
            System.out.println(sd1);
            StudentDetail sd2=session1.get(StudentDetail.class,1);
            System.out.println(sd2);

            session2=sessionFactory.openSession();
            transaction=session2.beginTransaction();
            StudentDetail sd3=session2.get(StudentDetail.class,1);
            System.out.println(sd3);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(flag==true) //it means done with the operation hence commit
            {
                transaction.commit();
            }
            else
            {
                // if not done with the operation then just rollback i.e., no changes at all
                transaction.rollback();
            }
            session1.close();
            session2.close();
            sessionFactory.close();
        }
    }

}
