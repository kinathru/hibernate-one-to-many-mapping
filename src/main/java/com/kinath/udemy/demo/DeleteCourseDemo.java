package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Course;
import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class ).addAnnotatedClass( InstructorDetail.class ).addAnnotatedClass( Course.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            int courseId = 2;
            Course course = session.get( Course.class, courseId );
            System.out.println( "Course is : " + course );
            session.delete( course );

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
