package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Adresse;
import model.Student;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			
			Adresse a1 = new Adresse("Berlin", "Windscheidstr 3");
			Adresse a2 = new Adresse("Berlin", "Frankfurtrt Allee 7");
			Student s1  = new Student("Max", a1);
			Student s2 = new Student("Erna", a2);
			session.save(s1);
			session.save(s2);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}finally {
			session.close();
		}
		
		

	}

}
