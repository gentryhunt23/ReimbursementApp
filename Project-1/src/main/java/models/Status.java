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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name = "status")

public class Status {

		@Id
		@Column(name = "reim_id")
		private int reimId;

		@Column(name = "status", nullable = false)
		private String status;
				
		public Status() {
		}
		public Status(String status) {
			this.status = status;
		}
		public Status(int reimId, String status) {
			this.reimId = reimId;
			this.status = status;
		}
		public int getReimId() {
			return reimId;
		}
		public void setReimId(int reimId) {
			this.reimId = reimId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

	}
