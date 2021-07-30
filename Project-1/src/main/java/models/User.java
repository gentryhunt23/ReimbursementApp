package models;

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

	@Entity
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
		
		@Column(name="password", unique=true, nullable=false)
		private String password;
		
		@Column(name="role", unique=true, nullable=true)
		private String role;
		
		@Column(name="email", unique=true, nullable=false)
		private String email;
		
		
		//We will also include some multiplicity annotations in a bit
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private List<Reimbursement> reimbursement;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="role")
		private UserRole userRole;
		
		public User() {}
		
		public User(int userId, String firstName, String lastName, String password, String email){
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			//this.role = UserRole;
			
		}
		public User(int userId, String firstName, String lastName, String password, String email, UserRole userRole, List<Reimbursement> reimbList) {
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			//this.role = userRole;
			//this.reimbList = reimbList;
			
		}
		public User(int userId, String firstName, String lastName, String username, String password, String email, UserRole userRole) {
			
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
			this.password = password;
			this.email = email;
			//this.role = userRole;
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
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
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
		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
					+ username + ", password=" + password + ", role=" + role + ", email=" + email + "]";

}
	}

