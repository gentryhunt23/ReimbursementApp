package driver;

import java.util.List;

import dao.ReimbursementDao;
import dao.UserDao;
import javassist.bytecode.analysis.Type;
import models.Reimbursement;
import models.ReinType;
import models.Status;
import models.User;
import models.UserRole;
import services.ReimbursementService;
import services.UserServices;


public class ReimbursementDriver {
	static User curUser = null;
	public static void main(String[] args) {
		ReimbursementDao rDao = new ReimbursementDao();
		ReimbursementService rs = new ReimbursementService();
		
		rs.updateStatus(26, 3);

		//		UserServices us = new UserServices();
//		curUser = us.login("GentryHunt4427","password");
//		//curUser = us.signUp("Gentry", "Hunt", "password", "ghunt@csu.edu", 2);
//	
//		Reimbursement r = new Reimbursement(1000,"Description2", 2, curUser);
//		rDao.createReim(r);
//		
//		List<Reimbursement> l = rDao.selectPending();
//		System.out.println(l.size());
//		for(Reimbursement x: l) {
//			System.out.println(x.toString());
//;
//		}
		// create new type

		//create new status
		
	}
	
	

}
