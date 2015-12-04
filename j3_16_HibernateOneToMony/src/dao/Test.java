package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.Department;
import model.Employee;

public class Test {

	 

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			 session.beginTransaction();
			 
		        Department department = new Department();
		        department.setDepartmentName("Sales");
		        session.save(department);
		         
		        Employee emp1 = new Employee("Nina", "Mayers", "111");
		        Employee emp2 = new Employee("Tony", "Almeida", "222");
		 
		        emp1.setDepartment(department);
		        emp2.setDepartment(department);
		         
		        session.save(emp1);
		        session.save(emp2);
		 
		        session.getTransaction().commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
