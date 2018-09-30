package com.project.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IEmployeeDao;
import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Service
public class EmployeeService implements IEmployeeService {
	
	
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmpDao() {
		return employeeDao;
	}

	@Autowired
	public void setEmpDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		
		return this.employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer empId) {
		
		return this.employeeDao.getEmployee(empId);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		
		return this.employeeDao.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		
		return this.employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee removeEmployee(Integer empId) {
		
		return this.employeeDao.removeEmployee(empId);
	}

}
