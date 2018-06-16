package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class ).addAnnotatedClass( InstructorDetail.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            System.out.println( "Searching Instructor 1 : " );
            Instructor instructor = session.get( Instructor.class, 1 );
            System.out.println( "Found instructor : " + instructor.toString() );

            System.out.println("Deleting Instructor : ");
            session.delete( instructor );
            System.out.println("Deleting Completed. ");

            session.getTransaction().commit();
        }
        finally
        {
            factory.close();
        }
    }
}
