package dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.User;
import util.HibernateUtil;

public class UserDao {
	
	public User createUser(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
		return user;
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
	public User getUser(String username, String password) {
		String sql = "SELECT * FROM users WHERE username =:username AND password =:password";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		if(query.list().size() == 0)
			return null;
		else return (User)query.list().get(0);
		
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}
	

}
