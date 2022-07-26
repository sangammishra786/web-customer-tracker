package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

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

			
			
			// start a transaction
			session.beginTransaction();

			//get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = 
						session.get(Instructor.class, theId);
			
			System.out.println("Found instructor : "+tempInstructor);
			
			//delete the instructors
			if(tempInstructor != null) {
				System.out.println("Deleting : "+tempInstructor);
				
				//Note: will also delete associated "details" object
				//because of cascadeType.ALL
				session.delete(tempInstructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			// Close the SessionFactory object
			factory.close();
		}

	}

}
