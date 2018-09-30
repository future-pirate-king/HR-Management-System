package com.project.hrmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Leave;
import com.project.hrmanagement.service.ILeaveService;

@RestController
public class LeaveController {
	
	
	//------working---------//
	
	//add leave  (needs changes as to accept data from json obj)
	
	
	
	
	
	private ILeaveService leaveService;
	
	@RequestMapping("/addLeave")
	public Leave addLeave() {
		
		@SuppressWarnings("deprecation")
		Leave l1 =new Leave((int)5,new Date(2017, 9, 15), new Date(2017, 9, 19),"Health",(int)1);
		return this.leaveService.addLeave(l1); 		
	}
	
	@RequestMapping("/getAllLeaves")
	public List<Leave> getAllLeaves() {	
	return this.leaveService.getAllLeaves();
		}
	
	
	@RequestMapping("/getLeave")
	public Leave getLeave(@RequestParam("leaveId") Integer leaveId) {
		if (leaveId != null) {
			Leave l1 = leaveService.getLeave(leaveId);
			if (l1 != null) {
				return l1;
			}
		}
		return null;
	}

	public ILeaveService getLeaveService() {
		return leaveService;
	}
	
	
	@Autowired
	public void setLeaveService(ILeaveService leaveService) {
		this.leaveService = leaveService;
	}

	
}
