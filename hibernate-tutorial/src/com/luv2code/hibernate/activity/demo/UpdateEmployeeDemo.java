package com.luv2code.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.activity.employee.entity.Employee;

public class UpdateEmployeeDemo {
	public static void main(String[] args) {
		// Create the sessionFactory object

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create the session object
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int employeeId = 2;
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting studentId : " + employeeId);
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			System.out.println("Updating the Employee....");
			myEmployee.setLast_Name("Mishra");
			
			session.getTransaction().commit();
			System.out.println("Updating is Done !!!");
			
			
			
		} finally {
			sessionFactory.close();
		}

	}
}
