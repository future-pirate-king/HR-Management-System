/*package com.project.hrmanagement.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Complaints;
import com.project.hrmanagement.service.IEmployeeComplaintsService;

@RestController
public class EmployeeComplaintsController {

	@Autowired
	private IEmployeeComplaintsService employeecomplaintsservice;

	@RequestMapping(value = "/addcomplaints")
	public Complaints addComplaints(Complaints complaints) {
		Integer empId = 35;
		@SuppressWarnings("deprecation")

		Complaints complaints1 = new Complaints(empId, "Technical", new Date("16-AUG-2017"),
				"the live server is not getting installed");
		return this.employeecomplaintsservice.addComplaints(complaints1);

	}
}
*/