package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Course;
import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo
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

            int instructorId = 1;
            Instructor instructor = session.get( Instructor.class, 1 );

            Course course1 = new Course( "Image Processing" );
            Course course2 = new Course( "Computer Architecture" );
            Course course3 = new Course( "Theory of Programming" );
            instructor.addCourses( course1 );
            instructor.addCourses( course2 );
            instructor.addCourses( course3 );

            session.save( course1 );
            session.save( course2 );
            session.save( course3 );

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
