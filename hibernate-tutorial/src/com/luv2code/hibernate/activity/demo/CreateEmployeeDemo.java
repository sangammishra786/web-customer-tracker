package com.luv2code.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.activity.employee.entity.Employee;

public class CreateEmployeeDemo {
	
	public static void main(String[] args) {
		
		//Load the hibernate configuration file
		//create SessionFacory object
		SessionFactory factory = new Configuration()
									 .configure()
									 .addAnnotatedClass(Employee.class)
									 .buildSessionFactory();
		
		//create the session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			System.out.println("Creating new Employee object....");
			
			//create the Employee Object
			Employee e1 = new Employee("Sangam", "Mishra", "HCL");
			Employee e2 = new Employee("Pawan", "Kumar", "VDO");
			Employee e3 = new Employee("Milan", "Mishra", "Napino");
			Employee e4 = new Employee("Kajal", "Satija", "MakeMyTrip");
			Employee e5 = new Employee("Shubhi", "Sharma", "TCS");
			Employee e6 = new Employee("Aman", "Rajput", "Abcd");
			
			//start the transaction
			session.beginTransaction();
						
			//save the Employee Object
			System.out.println("Save the Employee Records");
			session.save(e1);
			session.save(e2);
			session.save(e3);
			session.save(e4);
			session.save(e5);
			session.save(e6);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
				//close the sessionFactory object
				factory.close();
		}
	}
}
