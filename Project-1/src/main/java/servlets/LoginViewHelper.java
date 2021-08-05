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
			default:
				return "/Project-1/login";
		}
	}
	}