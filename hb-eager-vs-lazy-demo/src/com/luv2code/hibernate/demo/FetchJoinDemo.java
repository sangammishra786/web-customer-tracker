package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create sessionFactory
		SessionFactory factory = new Configuration()
				// .configure("hibernate.cfg.xml")
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			//Option 2: Hibernate query with HQL
			
			//get the instructor from db
			int theId = 1;
			//Instructor tempInstructor = session.get(Instructor.class, theId);
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+"JOIN FETCH i.courses "
							+"where i.id=:theInstructorId",
							Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor : " + tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\n\nLuv2code: The seesion is now closed!\n");
			
			
			//get course for the instructor
			System.out.println("luv2code: Courses : "+tempInstructor.getCourses());
			
			// commit the transaction
			//session.getTransaction().commit();

			System.out.println("luv2code: Done!!!");

		} finally {
			
			//add cleanup code
			session.close();
			
			// Close the SessionFactory object
			factory.close();
		}

	}

}
