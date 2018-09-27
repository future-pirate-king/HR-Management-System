package com.project.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.service.IEmployeeService;



//--------------working--------------//
// add employee  (needs changes as to accept data from json obj)
// remove employee  (needs changes as to accept data from json obj)
// get employee  (needs changes as to accept data from json obj)
// get all employee  (needs changes as to accept data from json obj)


@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return this.empService.addEmployee(employee);
	}

	@RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
	public boolean remove(@RequestParam Integer empId) {
		System.out.println(empId);
		if (empId != null) {
			Employee emp = empService.removeEmployee(empId);
			if (emp != null) {
				return true;
			}
		}
		return false;
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
