/*package com.project.hrmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EMPLOYEE_COMPLAINTS")
public class Complaints {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",
	parameters=@Parameter(name="property",value="employee"))
	
	@Id
	@Column(name = "complaint_id")
	private Integer complaintId;
	
	@Column(name="emp_id")
	private Integer empId;
	

	
	
	@Column(name = "complaint_type")
	private String complaintType;
	
	@Column(name = "complaint_date")
	private Date complaintDate;
	
	@Column(name = "complaint_description")
	private String complaintDescription;
	
	
	public Complaints(Integer empId, Integer complaintId, String complaintType, Date complaintDate,
			String complaintDescription) {
		super();
		this.empId = empId;
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintDate = complaintDate;
		this.complaintDescription = complaintDescription;
	}

	public Complaints(String complaintType, Date complaintDate, String complaintDescription) {
		super();
		this.complaintType = complaintType;
		this.complaintDate = complaintDate;
		this.complaintDescription = complaintDescription;
	}

	



	public Complaints() {
		// TODO Auto-generated constructor stub
	}
	
	public Complaints(Integer empId2, String string, Date date, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Complaints [empId=" + empId + ", complaintId=" + complaintId + ", complaintType=" + complaintType
				+ ", complaintDate=" + complaintDate + ", complaintDescription=" + complaintDescription + "]";
	}
	

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

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	
}
*/