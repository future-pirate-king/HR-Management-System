package com.project.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Complaints;
import com.project.hrmanagement.service.IComplaintsService;

@RestController
public class ComplaintsController {

	private IComplaintsService complaintsService;

	@RequestMapping(value = "/addComplaints", method = RequestMethod.POST)
	public Complaints addComplaints(@RequestBody Complaints complaints) {
		return this.complaintsService.addComplaints(complaints);

	}

	@RequestMapping("/listAllComplaints")
	public List<Complaints> listAllComplaints() {
		return this.complaintsService.listAllComplaints();
	}

	@RequestMapping("removeComplaints")
	public String remove(@RequestParam("complaintId") Integer complaintId) {
		if (complaintId != null) {
			Complaints c = complaintsService.removeComplaints(complaintId);
			if (c != null) {
				String st = "sucess";
				return st;
			}
		}
		return "Complaints with requested ID does not exist";
	}

	public IComplaintsService getComplaintsService() {
		return complaintsService;
	}

	@Autowired
	public void setComplaintsService(IComplaintsService complaintsService) {
		this.complaintsService = complaintsService;
	}

}
