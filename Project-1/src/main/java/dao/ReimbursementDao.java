package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import models.Reimbursement;

public class ReimbursementDao {
public ReimbursementDao() {
		
	}
	
	public void createReim(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(reimbursement);
		tx.commit();
	}
	
	public void updateReim(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(reimbursement);
		tx.commit();
	}
	
	public Reimbursement selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement crime = ses.get(Reimbursement.class, id);
		return crime;
	}
	
	public List<Reimbursement> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}
	
	

}
