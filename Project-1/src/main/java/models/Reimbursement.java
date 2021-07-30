package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimburesment")
		public class Reimbursement {
		
		@Id
		@Column(name="reimbursement_id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int reimId;
		
		@Column(name="reimbursement_amount", nullable=false)
		private int amount;
		
		@Column(name="reimbursement_submitted", nullable=true)
		private String submitted;
		
		@Column(name="reimbursement_resolved", nullable=true)
		private String resolved;
		
		@Column(name="reimbursement_description", nullable=false)
		private String description;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="user")
		private User user;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="type")
		private ReinType type;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="status")
		private Status status;

		
		
		public Reimbursement() {}
		
		public Reimbursement(int amount, String description) {
			this.amount = amount;
			this.description = description;
			
			
		}
		
		public Reimbursement(int reimId, int amount, String resolved, String description ) {
			this.reimId = reimId;
			this.amount = amount;
			this.resolved = resolved;
			this.description = description;
			
		}
		public int getReimId() {
			return reimId;
		}
		public void setReimId(int reimId) {
			this.reimId = reimId;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getSubmitted() {
			return submitted;
		}
		public void setSubmitted(String submitted) {
			this.submitted = submitted;
		}
		public String getResolved() {
			return resolved;
		}
		public void setResolved(String resolved) {
			this.resolved = resolved;
		}
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		@Override
		public String toString() {
			return "Reimbursement [reimId=" + reimId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
					+ resolved + ", description=" + description + "]";
		}

		


}
	
