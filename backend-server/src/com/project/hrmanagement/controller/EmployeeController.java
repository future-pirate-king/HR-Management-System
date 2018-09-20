package com.project.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;
import com.project.hrmanagement.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	@RequestMapping("/authenticate")
	public Employee authenticate() {
		//problem with id
		LoginCredential credential = new LoginCredential(new Integer(10653184), "sam");
		

		return empService.authenticate(credential);
	}
}
