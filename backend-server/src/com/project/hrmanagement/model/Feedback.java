package com.project.hrmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_FEEDBACK")
public class Feedback implements Serializable {

	private static final long serialVersionUID = 7470711278020128410L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "feedback_id")
	private Long feedbackId;
	
	@Column(name="emp_id")
	private Integer empId;

	@Column(name = "feedback_message")
	private String feedbackMessage;

	/*@ManyToOne
	@JoinColumn(name = "emp_Id", insertable = false, updatable = false, nullable = false)
	private Employee employee;*/
	
	
	
	
	
	

	public Feedback(Long feedbackId, String feedbackMessage, Integer empId) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackMessage = feedbackMessage;
		this.empId = empId;
	}

	public Feedback() {
		super();

	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	/*public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackMessage=" + feedbackMessage + ", empId=" + empId + "]";
	}


}
