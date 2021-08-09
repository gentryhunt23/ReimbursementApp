package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.SQLQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import util.HibernateUtil;

	@Entity
	@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
	@Table(name="users")
	public class User {

		@Id
		@Column(name="user_id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int userId;
		
		@Column(name="first_name", nullable=false)
		private String firstName;
		
		@Column(name="last_name", nullable=false)
		private String lastName;
		
		@Column(name="username", unique=true, nullable=false)
		private String username;
		
		@Column(name="password", nullable=false)
		private String password;

		
		@Column(name="email", nullable=false)
		private String email;
		
		
		//We will also include some multiplicity annotations in a bit
		@JsonIgnore
		@OneToMany(mappedBy = "rResolver", fetch = FetchType.LAZY)
		private List<Reimbursement> resolverList = new ArrayList<Reimbursement>();
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "uRole_FK")
		private UserRole uRole;
		
		@JsonIgnore
		@OneToMany(mappedBy = "rAuthor", fetch = FetchType.LAZY)
		private List<Reimbursement> authorList = new ArrayList<Reimbursement>();
			
		
		public User() {}
		public User(String firstName, String lastName, String password, String email, int role_id){
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			this.uRole = retrieveRole(role_id);
			
		}
		
		private UserRole retrieveRole(int role_id) {
			String sql = "SELECT * FROM user_role WHERE role_id = :id";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
			query.addEntity(UserRole.class);
			query.setParameter("id", role_id);
			List results = query.list();
			return (UserRole)results.get(0);
		}
		public User(int userId, String firstName, String lastName, String password, String email, int role_id){
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			this.uRole = retrieveRole(role_id);
			
		}
		public User(int userId, String firstName, String lastName, String password, String email, int role_id, List<Reimbursement> resolverList, List<Reimbursement> authorList) {
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			this.uRole = retrieveRole(role_id);
			this.resolverList = resolverList;
			this.authorList = authorList;

			
		}
		public List<Reimbursement> getResolverList() {
			return resolverList;
		}
		public void setResolverList(List<Reimbursement> resolverList) {
			this.resolverList = resolverList;
		}
		public List<Reimbursement> getAuthorList() {
			return authorList;
		}
		public void setAuthorList(List<Reimbursement> authorList) {
			this.authorList = authorList;
		}
		public User(int userId, String firstName, String lastName, String username, String password, String email, int role_id) {
			
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			this.uRole = retrieveRole(role_id);
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		

		public UserRole getuRole() {
			return uRole;
		}

		public void setuRole(UserRole uRole) {
			this.uRole = uRole;
		}
		
		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
					+ username + ", password=" + password + ", email=" + email + ", resolverList=" + resolverList
					+ ", uRole=" + uRole.getUserRoleId() + ", authorList=" + authorList + "]";
		}

	}

