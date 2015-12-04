package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import hibernate.User;
import util.HibernateUtil;

public class UserDAO {
	private SessionFactory  factory = HibernateUtil.getSessionFactory();
	
	
	
	public void attachUser(User user){
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		System.out.println(tr.wasCommitted());
		session.close();
		
		
		
	}
	
	
	//HQL
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
		Session session = factory.openSession();
		Query q = session.createQuery("From User");
		return q.list();
	}
	
	
	public void deleteUser(int id){
		
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		
		User delUser = (User) session.load(User.class, id);
		session.delete(delUser);
		tr.commit();
		System.out.println(tr.wasCommitted());
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findUserByExample(User exampleUser){
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		Example example = Example.create(exampleUser);
		criteria.add(example);
		
		return criteria.list();
	}
	
	public List<User> findByNachname(String nachname){
		Session session = factory.openSession();
		Query q = session.createQuery("From User where nachname= :n");
		q.setParameter("n", nachname);
		return q.list();
	}
	
	public User findUserById(int id){
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.idEq(id));
		List<User> li =criteria.list();
		return li.size() == 1? li.get(0): new User();
	}
	
	
	
	public User findByUsernameAndPassword(String usr, String pwd){
		Session session = factory.openSession();
		Query q = session.createQuery("From User where username= :un and password=:pw");
		q.setParameter("un", usr);
		q.setParameter("pw", pwd);
		List<User> li = q.list();
		
		return li.size() == 1? li.get(0): null;
		
	}
	
	/*
	 * Update
	 */
	public boolean updateEmail(int id , String newEmail){
		Session session = factory.openSession();
		session.beginTransaction();
		User user = (User) session.load(User.class,id);// bzw. get -> null
		user.setEmail(newEmail);
		session.getTransaction().commit();
		return session.getTransaction().wasCommitted();
	}
	public static void main(String[] args) {
		UserDAO dao  = new UserDAO();
		//dao.attachUser(new User("Marta", "Schultz","meri@eb.de","123","max"));
		System.out.println(dao.findAllUsers());
		
		User u1 = new User();
		u1.setNachname("Meier");
		u1.setVorname("Max");
		System.out.println(dao.findByNachname("Meier"));
	}
}
