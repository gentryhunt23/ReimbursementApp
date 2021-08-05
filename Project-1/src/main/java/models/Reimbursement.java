package models;

import java.util.List;

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

import org.hibernate.SQLQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import util.HibernateUtil;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name = "reimburesment")
public class Reimbursement {

	@Id
	@Column(name = "reimbursement_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reimId;

	@Column(name = "reimbursement_amount", nullable = false)
	private int amount;

	@Column(name = "reimbursement_submitted", nullable = true)
	private String submitted;

	@Column(name = "reimbursement_resolved", nullable = true)
	private String resolved;

	@Column(name = "reimbursement_description", nullable = false)
	private String description;

	 @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reim_author")
	private User rAuthor;

	 @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reim_resolver")
	private User rResolver;

	 @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "type")
	private ReinType rType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "status")
	private Status rStatus;
	public Reimbursement() {}
	
	public Reimbursement(int reimId) {
		this.reimId = reimId;

	}

	public Reimbursement(int amount, String description, int id) {
		this.amount = amount;
		this.description = description;
		this.rType = retrieveType(id);
		this.rStatus = retrieveStatus(1);


	}
	
	public Reimbursement(int amount, String description, int id, User user) {
		this.amount = amount;
		this.description = description;
		this.rType = retrieveType(id);
		this.rStatus = retrieveStatus(1);
		this.rAuthor = user;


	}
	
	private Status retrieveStatus(int id) {
		String sql = "SELECT * FROM status WHERE reim_id = :id";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Status.class);
		query.setParameter("id", id);
		List results = query.list();
		return (Status)results.get(0);
		
	}
	

	private ReinType retrieveType(int id) {
		String sql = "SELECT * FROM type WHERE reim_id = :id";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(ReinType.class);
		query.setParameter("id", id);
		List results = query.list();
		return (ReinType)results.get(0);
	}

	public Reimbursement(int reimId, int amount, String resolved) {
		this.reimId = reimId;
		this.amount = amount;
		this.resolved = resolved;

	}

	public Reimbursement(int reimId, int amount, String resolved, String description) {
		this.reimId = reimId;
		this.amount = amount;
		this.resolved = resolved;
		this.description = description;

	}

	public Reimbursement(int reimId, int amount, String resolved, String description, Status rStatus) {
		this.reimId = reimId;
		this.amount = amount;
		this.resolved = resolved;
		this.description = description;
		this.rStatus = rStatus;

	}

	public Reimbursement(int reimId, int amount, String resolved, String description, Status rStatus, ReinType rType) {
		this.reimId = reimId;
		this.amount = amount;
		this.resolved = resolved;
		this.description = description;
		this.rStatus = rStatus;
		this.rType = rType;

	}

	public User getrAuthor() {
		return rAuthor;
	}

	public void setrAuthor(User rAuthor) {
		this.rAuthor = rAuthor;
	}

	public User getrResolver() {
		return rResolver;
	}

	public void setrResolver(User rResolver) {
		this.rResolver = rResolver;
	}

	public ReinType getrType() {
		return rType;
	}

	public void setrType(ReinType rType) {
		this.rType = rType;
	}

	public Status getrStatus() {
		return rStatus;
	}

	public void setrStatus(Status rStatus) {
		this.rStatus = rStatus;
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
				+ resolved + ", description=" + description + ", rAuthor=" + rAuthor.getFirstName() + ", rResolver=" + ""
				+ ", rType=" + rType.getType() + ", rStatus=" + rStatus.getStatus() + "]";
	}

	public void updateRetrievedStatus(int statusId) {
		this.rStatus = retrieveStatus(statusId);
		
	}

}
