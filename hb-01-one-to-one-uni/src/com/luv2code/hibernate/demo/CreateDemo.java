package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create sessionFactory
		SessionFactory factory = new Configuration()
				// .configure("hibernate.cfg.xml")
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			//create the object
			
			Instructor tempInstructor = 
					new Instructor("Sangam", "Mishra", "sangam.kumar@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code !!!");
			
			
			/*Instructor tempInstructor = 
					new Instructor("Milan", "Kumar", "milan.kumar@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com",
						"Guitar !!!");
			*/
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
			// Close the SessionFactory object
			factory.close();
		}

	}

}
