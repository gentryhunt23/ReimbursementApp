package dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import models.Reimbursement;
import models.Status;
import models.User;

public class ReimbursementDao {
	Date date = new Date();

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
		Reimbursement r = ses.get(Reimbursement.class, id);
		return r;
	}

	public List<Reimbursement> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}

	public List<Reimbursement> selectPending() {
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE status =:status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new Status(1, "PENDING"));
		return query.list();
	}

	public List<Reimbursement> selectResolved() {
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE status NOT =:status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new Status(1, "PENDING"));
		return query.list();
	}

	public void updateStatus(int id, int statusId, User curUser) {
		Reimbursement selected = selectById(id);
		Timestamp resolved = new Timestamp(date.getTime());
		selected.updateRetrievedStatus(statusId);
		selected.setResolved(resolved);
		//selected.setrResolver(curUser);
		updateReim(selected);

	}

}
