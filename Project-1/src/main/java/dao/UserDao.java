package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.User;
import util.HibernateUtil;

public class UserDao {
	
	public void createUser(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
	}
	
	public void updateUser(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(user);
		tx.commit();
	}
	
	public User selectById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, id);
		return user;
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}

}
