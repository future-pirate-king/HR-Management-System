package com.project.hrmanagement.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.EmployeeAddress;
import com.project.hrmanagement.service.IEmployeeService;

//--------------working--------------//
// add employee  (needs changes as to accept data from json obj)
// remove employee  (needs changes as to accept data from json obj)
// get employee  (needs changes as to accept data from json obj)
// get all employee  (needs changes as to accept data from json obj)

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	private IEmployeeService employeeService;

	// add new employee
	@RequestMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		EmployeeAddress empadd = new EmployeeAddress();
		
		empadd.setCity(employee.getEmployeeAddress().getCity());
		empadd.setState(employee.getEmployeeAddress().getState());
		empadd.setCountry(employee.getEmployeeAddress().getCountry());
		empadd.setStreet(employee.getEmployeeAddress().getStreet());
		empadd.setZipcode(employee.getEmployeeAddress().getZipcode());

		employee.setEmployeeAddress(empadd);
		Set<Employee> employeeSet = new HashSet<>();
		// create Set

		employeeSet.add(employee);

		empadd.setEmployee(employee);

		return this.employeeService.addEmployee(employee);
	}

	//remove employee by passing employee Id
	@RequestMapping("removeEmployee")
	public String remove(@RequestParam("empId") Integer empId) {
		if (empId != null) {
			Employee emp = employeeService.removeEmployee(empId);
			if (emp != null) {
				String st = "sucess";
				return st;
			}
		}
		return "employee with requested ID does not exist";
	}

	//find employee using employee Id
	@RequestMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("empId") Integer empId) {
		if (empId != null) {
			Employee emp = employeeService.getEmployee(empId);
			if (emp != null) {
				return emp;
			}
		}
		return null;
	}

	//list all employees in database
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {

		return this.employeeService.getAllEmployee();
	}
	
	
	
	
	
	
	
	

	public IEmployeeService getEmpService() {
		return employeeService;
	}

	@Autowired
	public void setEmpService(IEmployeeService empService) {
		this.employeeService = empService;
	}

}
