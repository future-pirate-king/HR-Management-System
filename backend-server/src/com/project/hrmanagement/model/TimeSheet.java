package com.project.hrmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "HR_TIMESHEET")
public class TimeSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3163691523333594426L;

	@Id
	@GeneratedValue
	@Column(name = "time_sheet_id")
	private Integer timeSheetId;

	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "task_date")
	@PastOrPresent
	private Date taskDate;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "swipe_in")
	private String swipeIn;

	@Column(name = "swipe_out")
	private String swipeOut;

	/*
	 * @Column(name = "total_time") private Float totalTime = Float.valueOf(swipeIn)
	 * - Float.valueOf(swipeOut);
	 */

	@Column(name = "is_filled")
	private Integer isFilled = 0;

	@Column(name = "is_approved")
	private Integer isApproved = null;

	public TimeSheet() {
		// TODO Auto-generated constructor stub
	}

	public TimeSheet(Integer empId, Date taskDate, String taskName, String swipeIn, String swipeOut) {
		super();
		this.empId = empId;
		this.taskDate = taskDate;
		this.taskName = taskName;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	


	public Integer getIsFilled() {
		return isFilled;
	}

	public void setIsFilled(Integer isFilled) {
		this.isFilled = isFilled;
	}

	public Integer getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}

	public Integer getTimeSheetId() {
		return timeSheetId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(String swipeIn) {
		this.swipeIn = swipeIn;
	}

	public String getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(String swipeOut) {
		this.swipeOut = swipeOut;
	}

	/*
	 * public Float getTotalTime() { return totalTime; }
	 * 
	 * 
	 * 
	 * public void setTotalTime(Float totalTime) { this.totalTime = totalTime; }
	 */

}
