package com.project.hrmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public TimeSheet addTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.addTimeSheet(timeSheet);
	}

	@Override
	public Integer editTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.editTimeSheet(timeSheet);
	}


	@Override
	public Integer updateTimeSheetStatus(TimeSheet timeSheet) {
		return this.employeeTimeSheetDao.updateTimeSheetStatus(timeSheet);
	}

	@Override
	public Integer rejectTimeSheet(TimeSheet timeSheet) {
		// TODO Auto-generated method stub
		return this.employeeTimeSheetDao.rejectTimeSheet(timeSheet);
	}

}