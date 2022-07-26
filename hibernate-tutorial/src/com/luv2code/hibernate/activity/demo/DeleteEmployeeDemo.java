package com.luv2code.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.activity.employee.entity.Employee;

public class DeleteEmployeeDemo {
	
	public static void main(String[] args) {
		// Create the sessionFactory object

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create the session object
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//getting the current Session
			session = sessionFactory.getCurrentSession();
			
			//start the transaction
			session.beginTransaction();
			
			//Delete the records
			session.createQuery("delete from Employee where id = 6").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Delete Operation is Done !!!");
		} finally {
			sessionFactory.close();
		}
		
	}
}
