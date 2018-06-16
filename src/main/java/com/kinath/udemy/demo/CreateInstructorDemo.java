package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Course;
import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            Instructor instructor = new Instructor( "Susan", "Public", "susan.public@gmail.com" );
            InstructorDetail instructorDetail = new InstructorDetail( "Susan", "Playing Games" );
            instructor.setInstructorDetail( instructorDetail );

            System.out.println("Saving Instructor....");
            session.save( instructor );
            System.out.println("Saving Instructor Completed....");

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
