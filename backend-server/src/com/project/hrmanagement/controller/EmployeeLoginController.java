package com.project.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;
import com.project.hrmanagement.service.IEmployeeLoginService;
import com.project.hrmanagement.service.IEmployeeService;


//-----------working-----------//
// authentication (working completely with aungular and json obj) no changes req!!




@RestController
@RequestMapping("/LoginIn")
public class EmployeeLoginController {

	@Autowired
	IEmployeeLoginService employeeLoginService;

	@Autowired
	private IEmployeeService empService;

	public IEmployeeService getEmpService() {
		return empService;
	}

	public void setEmpService(IEmployeeService empService) {
		this.empService = empService;
	}

	public IEmployeeLoginService getEmployeeLoginService() {
		return employeeLoginService;
	}

	public void setEmployeeLoginService(IEmployeeLoginService employeeLoginService) {
		this.employeeLoginService = employeeLoginService;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Employee authenticate(@RequestBody LoginCredential lc) {

		if (this.empService.authenticate(lc)) {
			return this.empService.getEmployee(lc.getEmpId());
		}
		return null;
	}
}
