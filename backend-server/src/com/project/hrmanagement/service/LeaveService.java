package com.project.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.ILeaveDao;
import com.project.hrmanagement.model.Leave;

@Service
public class LeaveService implements ILeaveService {
	private ILeaveDao leaveDao;
	
	
	
	public ILeaveDao getLeaveDao() {
		return leaveDao;
	}
	
	
	@Autowired
	public void setLeaveDao(ILeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	@Override
	@Transactional
	public Leave addLeave(Leave leave) {
	return this.leaveDao.addLeave(leave);
	}

	@Override
	@Transactional
	public Leave getLeave(Integer leaveId) {
		return this.leaveDao.getLeave(leaveId);
	}

	@Override
	@Transactional
	public List<Leave> getAllLeaves() {
		return this.leaveDao.getAllLeaves();
		
	}

}
