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

@Entity
@Table(name = "status")

public class Status {

		@Id
		@Column(name = "reim_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int reimId;

		@Column(name = "status", nullable = false)
		private String status;
		
		@OneToMany(mappedBy="status", fetch=FetchType.LAZY)
		private List<Status> statList = new ArrayList<Status>();

		public Status(){
			
		}
		public Status(int reimId, String status) {
			this.reimId = reimId;
			this.status = status;
		}

	}
