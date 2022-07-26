package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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

			//create the object
					
			Instructor tempInstructor = 
					new Instructor("Milan", "Kumar", "milan.kumar@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com",
							"Video Games !!!");
			
			//associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();

			//save the instructor
			
			/*
			 * NOte: this will also save the details object
			 * because of cascadeType.ALL
			 */
			System.out.println("Saving instructor  :" + tempInstructor);
			session.save(tempInstructor);
			
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			
			//add cleanup code
			session.close();
			
			// Close the SessionFactory object
			factory.close();
		}

	}

}
