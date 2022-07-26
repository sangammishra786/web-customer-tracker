package com.luv2code.hibernate.activity.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.activity.employee.entity.Employee;

public class RetrievingEmployeeDemo {
	public static void main(String[] args) {

		// Create the sessionFactory object

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

		// create the session object
		Session session = sessionFactory.getCurrentSession();

		try {

			// Read the data from the database
			// start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// retrieve the data based on primary key
			System.out.println("Retrieve the data.......");
			List<Employee> empList = session.createQuery("from Employee").getResultList();
			
			for (Employee list : empList) {
				if (list.getId() == 5) {
					System.out.println("Retrieving details of Employee having Id : " + list.getId());
					Employee myEmployee = session.get(Employee.class, list.getId());
					System.out.println("Get Completed : " + myEmployee);

				}
			}
			
			//retrieving the employee details having last_name ='Mishra'
			System.out.println("Detail of employee having lastName 'Mishra'");
			empList = session.createQuery("from Employee where last_name='Mishra'").getResultList();
			displayEmployeeDetails(empList);
			

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!!");

		} finally {
			// close the sassionFactory object
			sessionFactory.close();
		}
	}

	private static void displayEmployeeDetails(List<Employee> empList) {
		for(Employee list1 : empList) {
			System.out.println(list1);
		}
	}

}
