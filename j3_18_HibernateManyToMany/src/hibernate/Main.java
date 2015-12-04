package hibernate;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Kurs;
import model.Student;

public class Main {
	
	static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	/*
	 * Kurse erzeugen
	 */
	public static void createCourseAndStudents(){
		Session session = sf.openSession();
		session.beginTransaction();
		Kurs k1 = new Kurs(1,"BWL");
		Kurs k2 = new Kurs(2,"Programmieren1");
		Kurs k3 = new Kurs(3,"Android");
		session.saveOrUpdate(k1);
		session.saveOrUpdate(k2);
		session.saveOrUpdate(k3);
		
		Student s1 = new Student(1,"Maxe", "Meier");
		Student s2 = new Student(2,"Ilse", "Schuster");
		Student s3 = new Student(3,"Otto", "Krause");
		session.saveOrUpdate(s1);
		session.saveOrUpdate(s2);
		session.saveOrUpdate(s3);
		
		
		session.getTransaction().commit();
		session.close();
		
	}
		
	
	/**
	 * Kurse dem Student entfernen
	 * @param student_id
	 * @param kurs_id
	 */
	public static void detachCourse(int student_id, int kurs_id){
		Session session = sf.openSession();
		session.beginTransaction();
		Student s = (Student) session.load(Student.class, student_id);
		Kurs k = (Kurs) session.load(Kurs.class, kurs_id);
		s.removeKurs(k);
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Kurse dem Student geben
	 * @param student_id
	 * @param kurs_id
	 */
	public static void atachCourse(int student_id, int kurs_id){
		Session session = sf.openSession();
		session.beginTransaction();
		Student s = (Student) session.load(Student.class, student_id);
		Kurs k = (Kurs) session.load(Kurs.class, kurs_id);
		s.addKurs(k);
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void deleteCourse( int kurs_id){
		Session session = sf.openSession();
		session.beginTransaction();
		Kurs k = (Kurs) session.load(Kurs.class, kurs_id);
		session.delete(k);
		session.getTransaction().commit();
		session.close();
	}
		

	public static void main(String[] args) {

//		
//		
		
		sf.close();
	}

}
