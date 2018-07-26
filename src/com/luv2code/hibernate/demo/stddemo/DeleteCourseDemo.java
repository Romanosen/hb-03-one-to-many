package com.luv2code.hibernate.demo.stddemo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        try {



            session.beginTransaction();

            //get the instructor from db
            int theId=1;
            Instructor tempInstructor=session.get(Instructor.class,theId);

            System.out.println("Instuctor :"+tempInstructor);

            System.out.println("Courses: "+ tempInstructor.getCourses());



            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
