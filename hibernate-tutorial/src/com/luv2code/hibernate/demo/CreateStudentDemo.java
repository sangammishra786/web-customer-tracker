package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create sessionFactory
		SessionFactory factory = new Configuration()
								// .configure("hibernate.cfg.xml")
								 .configure()
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			System.out.println("Creating new Student object....");
			
			//create a student object
			
			Student tempStudent1 = new Student("Pawan", "Mishra", "pawan@gmail.com");
			Student tempStudent2 = new Student("Kajal", "Satija", "kajal@gmail.com");
			Student tempStudent3 = new Student("Aman", "Rajput", "Aman@gmail.com");
			Student tempStudent4 = new Student("Saurabh", "Yadav", "saurabh@gmail.com");
			Student tempStudent5 = new Student("Sangam", "Kumar", "sangam@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			session.save(tempStudent5);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//Read the data from the database
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary Key
			System.out.println("\nGetting student with Id: "+ tempStudent1.getId());
			Student myStudent = session.get(Student.class, tempStudent1.getId());
			System.out.println("Get Completed: "+myStudent);
			
			//commit the transaction
			session.getTransaction();
			
			System.out.println("Done!!!");
			
		} finally {
			//Close the SessionFactory object
			factory.close();
		}
		

	}

}
