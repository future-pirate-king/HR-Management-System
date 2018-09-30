package com.project.hrmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IEmployeeTimeSheetDao;
import com.project.hrmanagement.model.TimeSheet;

@Service
public class EmployeeTimesheetService implements IEmployeeTimesheetService {

	private IEmployeeTimeSheetDao employeeTimeSheetDao;

	public IEmployeeTimeSheetDao getEmployeeTimeSheetDao() {
		return employeeTimeSheetDao;
	}

	@Autowired
	public void setEmployeeTimeSheetDao(IEmployeeTimeSheetDao employeeTimeSheetDao) {
		this.employeeTimeSheetDao = employeeTimeSheetDao;
	}

	@Override
	@Transactional
	public TimeSheet addTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.addTimeSheet(timeSheet);
	}

	@Override
	@Transactional
	public Integer editTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.editTimeSheet(timeSheet);
	}

	@Override
	@Transactional
	public Integer updateTimeSheetStatus(TimeSheet timeSheet) {
		return this.employeeTimeSheetDao.updateTimeSheetStatus(timeSheet);
	}

	@Override
	@Transactional
	public Integer rejectTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.rejectTimeSheet(timeSheet);
	}

	@Override
	@Transactional
	public List<TimeSheet> findTimeSheet(Integer empId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return employeeTimeSheetDao.findTimeSheet(empId, startDate, endDate);
	}

	@Override
	@Transactional
	public List<TimeSheet> getEmployeeTimeSheets(Integer empId) {
		// TODO Auto-generated method stub
		return employeeTimeSheetDao.getEmployeeTimeSheets(empId);
	}

}