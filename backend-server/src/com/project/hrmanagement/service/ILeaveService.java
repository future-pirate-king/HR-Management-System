package com.project.hrmanagement.service;

import java.util.List;

import com.project.hrmanagement.model.Leave;

public interface ILeaveService {
	public Leave addLeave(Leave leave);
	public Leave getLeave(Integer leaveId);
	public List<Leave> getAllLeaves();
}
