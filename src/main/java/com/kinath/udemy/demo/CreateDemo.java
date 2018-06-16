package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class ).addAnnotatedClass( InstructorDetail.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            Instructor instructor = new Instructor( "Kinath", "Rupasinghe", "kinath@gmail.com" );
            InstructorDetail instructorDetail = new InstructorDetail( "kinathru", "Playing Guitar" );
            instructor.setInstructorDetail( instructorDetail );

            System.out.println("Saving Instructor....");
            session.save( instructor );
            System.out.println("Saving Instructor Completed....");

            session.getTransaction().commit();
        }
        finally
        {
            factory.close();
        }
    }
}
