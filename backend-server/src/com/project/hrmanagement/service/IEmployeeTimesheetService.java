package com.project.hrmanagement.service;

import java.util.Date;
import java.util.List;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.TimeSheet;

public interface IEmployeeTimesheetService {

	public TimeSheet addTimeSheet(TimeSheet timeSheet);

	public Integer editTimeSheet(TimeSheet timeSheet);

	public Integer updateTimeSheetStatus(TimeSheet timeSheet);

	public Integer rejectTimeSheet(TimeSheet timeSheet);

	public List<TimeSheet> findTimeSheet(Integer empId, Date startDate, Date endDate);
	public List<TimeSheet> getEmployeeTimeSheets(Integer empId);

}
