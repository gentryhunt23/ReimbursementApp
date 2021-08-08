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
		}
	}
}
	
