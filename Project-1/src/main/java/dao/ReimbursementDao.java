package dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import models.Reimbursement;
import models.Status;
import models.User;

public class ReimbursementDao {
public ReimbursementDao() {
		
	}
	
	public void createReim(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(reimbursement);
		tx.commit();
	}
	
	public Reimbursement selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement r = ses.get(Reimbursement.class, id);
		return r;
	}
	
	public List<Reimbursement> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}
	public List<Reimbursement> selectPending(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE status =:status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new Status(1, "PENDING"));
		return query.list();
	}
	public List<Reimbursement> viewResolved(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE status NOT =:status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new Status(1, "PENDING"));
		return query.list();
	}
	public void updateReim(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(reimbursement);
		tx.commit();
	}
	
	//moved from services
	public void updateStatus(int id, int statusId) {
		Reimbursement selected = selectById(id);
		selected.updateRetrievedStatus(statusId);
		updateReim(selected);
	
	}
	
	

}
