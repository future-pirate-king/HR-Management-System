package com.project.hrmanagement.controller;

import java.util.Date;
import java.util.List;

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
		int testId = 1;
		LoginCredential credential = new LoginCredential(testId, "Newuser");
		if(this.empService.authenticate(credential)) {
			return this.empService.getEmployee(testId);
		}
		return null;
	}
	
	@RequestMapping("/addEmployee")
	public Employee addEmployee(){
		@SuppressWarnings("deprecation")
		Employee emp = new Employee("Viraj", "vinayak", "bhat", "O +ve", "9930801188", "viraj@gmail", "get1",
				new Date("16-AUG-2017"), "java", new Date("16-AUG-2017"), "male", "single", "kapil");
		return this.empService.addEmployee(emp);
	}
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		
		return this.empService.getAllEmployee();
	}
}
