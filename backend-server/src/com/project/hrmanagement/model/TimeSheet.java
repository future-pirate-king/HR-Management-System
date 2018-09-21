package com.project.hrmanagement.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TIME_SHEET")
public class TimeSheet {
	private Integer hours;
	private Integer minutes;
	private Time inTime;
	private Time outTime;
	private String taskName;

	public enum weekDays {
		monday, tuesday, wednesday, thrusday, friday, saturday, sunday;

	}
	
	
	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Time getInTime() {
		return inTime;
	}

	public void setInTime(Time inTime) {
		this.inTime = inTime;
	}

	public Time getOutTime() {
		return outTime;
	}

	public void setOutTime(Time outTime) {
		this.outTime = outTime;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

}
