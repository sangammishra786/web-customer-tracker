package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create sessionFactory
		SessionFactory factory = new Configuration()
				// .configure("hibernate.cfg.xml")
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			/*
			 * int studentId = 1; // start a transaction session =
			 * factory.getCurrentSession(); session.beginTransaction();
			 * 
			 * // delete the student based on id System.out.println("\nGetting studentId : "
			 * + studentId);
			 * 
			 * Student theStudent = session.get(Student.class, studentId);
			 * 
			 * System.out.println("Delete the Student"); session.delete(theStudent);
			 * 
			 * // commit the transaction session.getTransaction().commit();
			 */

			//NEW CODE to delete the record using executeUpdate() method
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\nDelete the record whose Id is 2");
			session.createQuery("delete from Student where Id=2")
				   .executeUpdate();
			
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			// Close the SessionFactory object
			factory.close();
		}

	}

}
