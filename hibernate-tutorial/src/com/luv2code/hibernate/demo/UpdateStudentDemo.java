package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create sessionFactory
		SessionFactory factory = new Configuration()
				// .configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieving the student based on id
			System.out.println("\nGetting studentId : " + studentId);

			Student theStudent = session.get(Student.class, studentId);

			System.out.println("Updating the Student");
			theStudent.setFirstName("King");

			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Updating email of all student");

			session.createQuery("update Student set email = 'yahoo@gmail.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			// Close the SessionFactory object
			factory.close();
		}

	}

}
