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
@Table(name = "type")
public class ReinType {
	
	@Id
	@Column(name="reim_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimId;
	
	@Column(name="type", nullable=false)
	private String type;
	
//	@OneToMany(mappedBy="rType", fetch=FetchType.LAZY)------> Ask Ethan why?
//	private List<Reimbursement> reimList = new ArrayList<>();
//	
//	public List<Reimbursement> getRtList() {
//		return reimList;
//	}
//	public void setRtList(List<Reimbursement> reimList) {
//		this.reimList = reimList;
//	}
	
	public ReinType(){
	
	}

	public ReinType(int reimId, String type){
		this.reimId = reimId;
		this.type = type;
	
	}
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Type [reimId=" + reimId + ", type=" + type + "]";
	}
	
	
}
//do you need this class?