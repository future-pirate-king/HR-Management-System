package com.project.hrmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;
import com.project.hrmanagement.service.IEmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Employee authenticate(@RequestBody LoginCredential lc) {

		if (this.empService.authenticate(lc)) {
			return this.empService.getEmployee(lc.getEmpId());
		}
		return null;
	}

	@RequestMapping("/addEmployee")
	public Employee addEmployee() {
		@SuppressWarnings("deprecation")
		Employee emp = new Employee("Viraj", "vinayak", "bhat", "O +ve", "9930801188", "viraj@gmail", "get1",
				new Date("16-AUG-2017"), "java", new Date("16-AUG-2017"), "male", "single", "kapil");

		return this.empService.addEmployee(emp);
	}

	@RequestMapping("removeEmployee")
	public String remove(@RequestParam("empId") Integer empId) {
		if (empId != null) {
			Employee emp = empService.removeEmployee(empId);
			if (emp != null) {
				String st = "sucess";
				return st;
			}
		}
		return "employee with requested ID does not exist";
	}

	@RequestMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("empId") Integer empId) {
		if (empId != null) {
			Employee emp = empService.getEmployee(empId);
			if (emp != null) {
				return emp;
			}
		}
		return null;
	}

	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {

		return this.empService.getAllEmployee();
	}

}
