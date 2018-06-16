package com.kinath.udemy.demo;

import com.kinath.udemy.entity.Instructor;
import com.kinath.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Instructor.class ).addAnnotatedClass( InstructorDetail.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            int theId = 3;
            InstructorDetail instructorDetail = session.get( InstructorDetail.class, theId );
            System.out.println( instructorDetail.toString() );
            System.out.println( instructorDetail.getInstructor().toString() );

            System.out.println("Deleting Instructor Detail : ");
            instructorDetail.getInstructor().setInstructorDetail( null );
            session.delete( instructorDetail );

            session.getTransaction().commit();
        }
        finally
        {
            factory.close();
        }
    }
}
