package com.project.hrmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HR_FEEDBACK")
public class Feedback {

	

	@Id
	@Column(name = "feedback_id")
	/*@SequenceGenerator(name="id", initialValue=0000, allocationSize=100)*/
	@GeneratedValue/*(strategy = GenerationType.SEQUENCE, generator="id")*/
	private Integer feedbackId;
	
	@Column(name="feedback_rating")
	private String feedbackRating;
	
	@Column(name="feedback_category")
	private String feedbackCategory;

	@Column(name = "feedback_description")
	private String feedbackDescription;

	@Column(name="emp_id")
	private Integer empId;
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	

	public String getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(String feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

	public String getFeedbackCategory() {
		return feedbackCategory;
	}

	public void setFeedbackCategory(String feedbackCategory) {
		this.feedbackCategory = feedbackCategory;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

	
public Feedback() {
	// TODO Auto-generated constructor stub
}
	@Override
	public String toString() {
		return "Feedback [feedbackRating=" + feedbackRating + ", feedbackCategory=" + feedbackCategory
				+ ", feedbackDescription=" + feedbackDescription + "]";
	}

	public Feedback(String feedbackRating, String feedbackCategory, String feedbackDescription) {
		super();
		this.feedbackRating = feedbackRating;
		this.feedbackCategory = feedbackCategory;
		this.feedbackDescription = feedbackDescription;
	}



	
	


}
