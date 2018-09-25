package com.project.hrmanagement.Dao;

import java.util.List;

import com.project.hrmanagement.model.Leave;


public interface ILeaveDao {

	public Leave addLeave(Leave leave);
	public Leave getLeave(Integer leaveId);
	public List<Leave> getAllLeaves();
}
