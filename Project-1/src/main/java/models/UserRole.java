package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.SQLQuery;

import util.HibernateUtil;
@Entity
@Table(name = "user_role")
public class UserRole {

		@Id
		@Column(name = "role_id")
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private int userId;

		@Column(name = "user_role", nullable = false)
		private String userRole;

		@OneToMany(mappedBy="uRole", fetch=FetchType.LAZY)
		private List<User> uList = new ArrayList<User>();
		
		public UserRole() {

		}
		public UserRole(int userId, String userRole) {
			this.userId = userId;
			this.userRole = userRole;

		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}

	}

