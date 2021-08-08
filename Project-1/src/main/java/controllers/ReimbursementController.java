package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReimbursementDao;
import dao.UserDao;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReimbursementController {
	
	private static ReimbursementDao rDao = new ReimbursementDao();
	private static UserDao uDao = new UserDao();
	private static ReimbursementService rServ = new ReimbursementService();
	private static UserServices uServ = new UserServices();
	
	public static void handleReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		if(req.getMethod().equals("GET")) {
			System.out.println("in the handle reimbursements method");
			
			List<Reimbursement> reimbs = rDao.selectAll();
			System.out.println(reimbs);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET");
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
			
		}
		else {
			//To read in stringified JSON data is a bit more complicated,
			//front end data conversion to readable string
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
			String data = buffer.toString();
			System.out.println(data);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode parsedObj = mapper.readTree(data);
			
			int userId = Integer.parseInt(parsedObj.get("userId").asText());
			int amount = Integer.parseInt(parsedObj.get("amount").asText());
			String description = parsedObj.get("description").asText();
			int typeId = Integer.parseInt(parsedObj.get("typeId").asText());

			User u = uDao.selectById(userId);
			//pServ.addPost(u, content);
			Reimbursement r = new Reimbursement(amount, description, typeId, u);
			rDao.createReim(r);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new reimbursment");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			//res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
			res.getWriter().write(new ObjectMapper().writeValueAsString(r));

		}
	}
	public static void viewPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		if(req.getMethod().equals("GET")) {
			System.out.println("in the pending reimbursements method");
			
			List<Reimbursement> pendingRemibs = rDao.selectPending();
			System.out.println(pendingRemibs);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET");
			res.getWriter().write(new ObjectMapper().writeValueAsString(pendingRemibs));
			
		}
	}
	public static void updateReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
			System.out.println("in the handle reimbursements method");
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
			String data = buffer.toString();
			System.out.println(data);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode parsedObj = mapper.readTree(data);
			
			int reimId = Integer.parseInt(parsedObj.get("reimId").asText());
			int status = Integer.parseInt(parsedObj.get("status").asText());

			rDao.updateStatus(reimId, status);
			
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully resolved the existing reimbursment");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			//res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
			
			

		}
		
}