package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.ReimbursementDao;
import models.Reimbursement;
import models.User;
import services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class LoginController {

	private static UserDao uDao = new UserDao();
	private static UserServices uServ = new UserServices();

	public static void login(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {

		// To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();

		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();

		try {
			System.out.println("In the post handler");
			User u = uServ.login(username, password);

			int id = u.getUserId();
			int role = u.getuRole().getUserRoleId();
			System.out.println("This is the user role " + role);

			System.out.println(u);
			// We will keep track of if the user is logged in by storing their id in the
			// session
			req.getSession().setAttribute("userRole", role);
			req.getSession().setAttribute("id", id);
			res.setStatus(HttpServletResponse.SC_OK);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));

			// if receive an infinite loop error---Stack Overflow Error (Jackson)

//			ObjectNode user = mapper.createObjectNode();
//			user.put("userId", id);
//			user.put("userRole", role);
//			res.getWriter().write(new ObjectMapper().writeValueAsString(user));

		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or password incorrect");
		}
	}

	public static void viewAllUsers(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		if (req.getMethod().equals("GET")) {
			System.out.println("in the view all users  method");

			List<User> uList = uDao.selectAll();
			System.out.println(uList);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET");
			res.getWriter().write(new ObjectMapper().writeValueAsString(uList));

		}
	}

	public static void register(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {

		// To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();

		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		String firstName = parsedObj.get("firstName").asText();
		String lastName = parsedObj.get("lastName").asText();
		String email = parsedObj.get("email").asText();
		String password = parsedObj.get("password").asText();
		String confirmPassword = parsedObj.get("confirmPassword").asText();
		String pin = parsedObj.get("pin").asText();
		if(pin.equals("460515")) {

		try {
			System.out.println("In the register function");
			User u = uServ.signUp(firstName, lastName, password, email, 2);

			System.out.println("this is u" + u);
			// We will keep track of if the user is logged in by storing their id in the
			// session
			// req.getSession().setAttribute("userRole", role);
			// req.getSession().setAttribute("id", u.getUserId());

			res.getWriter().write(new ObjectMapper().writeValueAsString(u));

			// if receive an infinite loop error---Stack Overflow Error (Jackson)
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully created a new user");
			res.setStatus(HttpServletResponse.SC_OK);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
//			user.put("userRole", role);
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));

		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or password incorrect");
		}
		}else {
			try {
				System.out.println("In the register function");
				User u = uServ.signUp(firstName, lastName, password, email, 1);

				System.out.println(u);
				// We will keep track of if the user is logged in by storing their id in the
				// session
				// req.getSession().setAttribute("userRole", role);
				// req.getSession().setAttribute("id", u.getUserId());

				res.getWriter().write(new ObjectMapper().writeValueAsString(u));

				// if receive an infinite loop error---Stack Overflow Error (Jackson)
				ObjectNode ret = mapper.createObjectNode();
				ret.put("message", "successfully created a new user");
				res.setStatus(HttpServletResponse.SC_OK);
				res.addHeader("Access-Control-Allow-Origin", "*");
				res.setHeader("Access-Control-Allow-Methods", "POST");
//				user.put("userRole", role);
				res.getWriter().write(new ObjectMapper().writeValueAsString(u));

			} catch (Exception e) {
				e.printStackTrace();
				res.setStatus(HttpServletResponse.SC_FORBIDDEN);
				res.getWriter().println("Username or password incorrect");
			}
			
			
		}
	}

}