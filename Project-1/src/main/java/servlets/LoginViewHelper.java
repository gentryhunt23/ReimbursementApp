package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import controllers.LoginViewController;

public class LoginViewHelper {

	public static String process(HttpServletRequest req) throws IOException, ServletException{
		System.out.println("In the view dispatcher process method, with URI: " +req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/Project-1/login":
			return LoginViewController.fetchLoginPage(req);
		case "/Project-1/manager" :
			return LoginViewController.fetchManagerPage(req);
		case "/Project-1/employee" :
			return LoginViewController.fetchEmployeePage(req);
		case "/Project-1/users" :
			return LoginViewController.fetchUsersPage(req);
		case "/Project-1/register" :
			return LoginViewController.fetchRegistrationPage(req);
			default : System.out.println("something is broken");
			return "This is the switchs case return statement in the view helper";
				
		}
	}
	}