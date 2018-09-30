package com.project.hrmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IEmployeeDao;
import com.project.hrmanagement.Dao.IEmployeeLoginDao;
import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Service
public class EmployeeLoginService implements IEmployeeLoginService {

	IEmployeeLoginDao EmployeeLoginDao;

	private IEmployeeDao empDao;

	public IEmployeeDao getEmpDao() {
		return empDao;
	}

	@Autowired
	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	public IEmployeeLoginDao getEmployeeLoginDao() {
		return EmployeeLoginDao;
	}

	@Autowired
	public void setEmployeeLoginDao(IEmployeeLoginDao employeeLoginDao) {
		EmployeeLoginDao = employeeLoginDao;
	}

	@Override
	@Transactional
	public boolean authenticate(LoginCredential logincredential) {

		return this.EmployeeLoginDao.authenticate(logincredential);
	}

	@Override
	@Transactional
	public List<String> getLastLogin(Integer empId) {
		return this.EmployeeLoginDao.getLastLogin(empId);
	}

	@Override
	@Transactional
	public Boolean resetPassword(String newPass,Integer empId) {
		return EmployeeLoginDao.resetPassword(newPass,empId);
	}

	@Override
	public Boolean OtpGenerator() {
		// TODO Auto-generated method stub
		return EmployeeLoginDao.OtpGenerator();
	}

	@Override
	public Boolean OtpVerifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String getEmployeeMail(Integer empId) {
		// TODO Auto-generated method stub
		return EmployeeLoginDao.getEmployeeMail(empId);
	}


}
