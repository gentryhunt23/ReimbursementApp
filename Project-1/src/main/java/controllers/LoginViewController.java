package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.ReimbursementDao;
import models.User;
import services.UserServices;

public class LoginViewController {
	
	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view login.html");
		return "resources/html/index.html";
		
	}
	public static String fetchManagerPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view manager.html");
		return "resources/html/manager.html";
		
	}
	public static String fetchEmployeePage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view employee.html");
		return "resources/html/employee.html";
		
	}
	public static String fetchUsersPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view users.html");
		return "resources/html/users.html";
		
	}
	public static String fetchRegistrationPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view registration.html");
		return "resources/html/register.html";
		
	}
	
	
}