package com.project.hrmanagement.service;

import java.util.List;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee getEmployee(Integer empId);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee employee);
	public Employee removeEmployee(Integer empId);
}
