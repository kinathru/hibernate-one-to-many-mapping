package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Course;
import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourses
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class ).addAnnotatedClass( InstructorDetail.class ).addAnnotatedClass( Course.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            int instructorId = 1;
            Instructor instructor = session.get( Instructor.class, instructorId );
            System.out.println( "Instructor : "  + instructor.toString() );
            System.out.println( "Courses : "  + instructor.getCourses() );


            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
