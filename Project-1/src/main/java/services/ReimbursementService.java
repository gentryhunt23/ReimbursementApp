package services;

import java.util.List;

import dao.ReimbursementDao;
import models.Reimbursement;

public class ReimbursementService {
	ReimbursementDao rd = new ReimbursementDao();
	
	public List<Reimbursement> viewPending() {
		return rd.selectPending();
		
	}
	public List<Reimbursement> viewResolved() {
		return rd.viewResolved();
		
	}
	

}
