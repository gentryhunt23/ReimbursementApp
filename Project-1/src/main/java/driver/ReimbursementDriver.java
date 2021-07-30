package driver;

import dao.ReimbursementDao;
import dao.UserDao;
import javassist.bytecode.analysis.Type;
import models.Reimbursement;
import models.ReinType;
import models.Status;
import models.User;


public class ReimbursementDriver {
	
	public static void main(String[] args) {
		UserDao uDao = new UserDao();
		ReimbursementDao rDao = new ReimbursementDao();
		
		User u = new User(0,"Gentry", "Hunt", "password", "ghunt@csu.edu");
		uDao.createUser(u);
		
		Reimbursement r = new Reimbursement(1000,"Description");
		rDao.createReim(r);
		// create new type
		ReinType type = new ReinType(0, "TypeTest");

		//create new status
		Status stat = new Status(0, "STATUS");
		
	}

}
