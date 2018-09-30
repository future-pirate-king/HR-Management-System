package com.project.hrmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HR_COMPLAINTS")
public class Complaints {
	
	
	
	@Id
	@Column(name = "complaint_id")
	@SequenceGenerator(name="id", initialValue=0000, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Integer complaintId;
	
	@Column(name = "complaint_type")
	private String complaintType;
	
	@Column(name = "complaint_description")
	private String complaintDescription;
	
	@Column(name="complaint_status")
	private Boolean complaintStatus;

	@Column(name="emp_id")
	private Integer empId;
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}


	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	
	public Boolean getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(Boolean complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	
	public Complaints() {
		
	}

	public Complaints(String complaintType, String complaintDescription, Boolean complaintStatus, Integer empId) {
		super();
		this.complaintType = complaintType;
		this.complaintDescription = complaintDescription;
		this.complaintStatus = complaintStatus;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Complaints [complaintId=" + complaintId + ", complaintType=" + complaintType + ", complaintDescription="
				+ complaintDescription + ", complaintStatus=" + complaintStatus + ", empId=" + empId + "]";
	}

	

}
