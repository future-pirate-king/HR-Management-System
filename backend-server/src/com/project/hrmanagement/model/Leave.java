package com.project.hrmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HR_LEAVE")
public class Leave implements Serializable {
	
	private static final long serialVersionUID = -2536502200304825780L;

	@Id
	@Column(name="leave_id")
	@GeneratedValue
	private Integer leaveId;
	
	@Column(name="number_of_leaves_taken")
	private Integer numberOfLeavesTaken;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="leave_balance")
	private Integer leaveBalance;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getNumberOfLeavesTaken() {
		return numberOfLeavesTaken;
	}

	public void setNumberOfLeavesTaken(Integer numberOfLeavesTaken) {
		this.numberOfLeavesTaken = numberOfLeavesTaken;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public Leave(Integer leaveId, Integer numberOfLeavesTaken, Date fromDate, Date toDate, String reason,
			Integer leaveBalance) {
		super();
		this.leaveId = leaveId;
		this.numberOfLeavesTaken = numberOfLeavesTaken;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.leaveBalance = leaveBalance;
	}

	public Leave() {
		
	}

	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", numberOfLeavesTaken=" + numberOfLeavesTaken + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", reason=" + reason + ", leaveBalance=" + leaveBalance + "]";
	}
	
	
	
	
	

}
