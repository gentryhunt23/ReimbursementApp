package driver;

import java.sql.Timestamp;
import java.util.Date;
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
		//ReimbursementService rs = new ReimbursementService();


		UserServices us = new UserServices();
		curUser = us.login("GentryHunt3064", "password");
		//curUser = us.signUp("Gentry", "Hunt", "password1", "ghunt@csu.edu2", 1);
		rDao.updateStatus(63, 2, curUser);

		// amount, description, type, user
		//Reimbursement r = new Reimbursement(1000, "Description2", 2, curUser);
		//rDao.createReim(r);

//		List<Reimbursement> l = rDao.selectPending();
//		System.out.println(l.size());
//		for (Reimbursement x : l) {
//			System.out.println(x.toString());
//			;
		}

	}


