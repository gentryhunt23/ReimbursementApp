package services;

import java.util.List;

import dao.ReimbursementDao;
import models.Reimbursement;

public class ReimbursementService {
	ReimbursementDao rd = new ReimbursementDao();
	
	public List<Reimbursement> viewPending() {
		return rd.selectPending();
		
	}
	public void updateStatus(int id, int statusId) {
		Reimbursement selected = rd.selectById(id);
		selected.updateRetrievedStatus(statusId);
		rd.updateReim(selected);
	
	}

	

}
