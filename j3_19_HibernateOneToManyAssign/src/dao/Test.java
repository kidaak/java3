package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.Artist;
import model.Links;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Links l1 = new Links("www.hasd.de", "MySpace");
			Links l2 = new Links("www.lastfm.de", "Lastfm");
			Set<Links> set = new HashSet<>();
			set.add(l1);
			set.add(l2);

			Artist artist = new Artist("a266", "Maxe", set);

			session.saveOrUpdate(artist);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
