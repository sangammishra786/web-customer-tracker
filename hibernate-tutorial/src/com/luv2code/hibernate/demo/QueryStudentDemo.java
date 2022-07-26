package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create sessionFactory
		SessionFactory factory = new Configuration()
				// .configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			//query Student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display Students
			displayStudent(theStudents);
			
			//query Student lastName : mishra
			 theStudents = session.createQuery("from Student s where s.lastName = 'Mishra'").getResultList();
			
			//display Students
			System.out.println("\nStudent List Where lastName is Mishra");
			displayStudent(theStudents);
			
			//query Student emailId is like '@gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display Students
			System.out.println("\n\nStudent Email List");
			displayStudent(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			// Close the SessionFactory object
			factory.close();
		}

	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
