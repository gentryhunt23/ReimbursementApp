package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.LoginViewController;
import controllers.LoginController;
import controllers.LogoutController;
import controllers.ReimbursementController;
import controllers.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
		
			case "/Project-1/api/login":
				LoginController.login(req, res);
				break;
			case "/Project-1/api/manager/view-reimbursements":
			ReimbursementController.handleReimbursements(req, res);
			break;
			case "/Project-1/api/employee/create":
				ReimbursementController.handleReimbursements(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/employee/view-reimbursements":
				ReimbursementController.handleReimbursements(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/manager/view/pending":
				ReimbursementController.viewPending(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/manager/resolve":
				ReimbursementController.updateReimb(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/manager/view-resolved":
				ReimbursementController.viewResolved(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/users":
				LoginController.viewAllUsers(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/users/reimbursements":
				ReimbursementController.viewReimFromAuthor(req, res);
				//SessionController.getSession(req, res);
				break;
			case "/Project-1/api/user/register":
				LoginController.register(req, res);
				//SessionController.getSession(req, res);
				break;
				
		}
	}
}
	
