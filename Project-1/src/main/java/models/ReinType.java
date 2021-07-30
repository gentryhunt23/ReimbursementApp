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
@Table(name = "type")
public class ReinType {
	
	@Id
	@Column(name="reim_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimId;
	
	@Column(name="type", unique=true, nullable=false)
	private String type;
	
	@OneToMany(mappedBy="type", fetch=FetchType.LAZY)
	private List<ReinType> rtList = new ArrayList<>();
	
	public List<ReinType> getRtList() {
		return rtList;
	}
	public void setRtList(List<ReinType> rtList) {
		this.rtList = rtList;
	}
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
