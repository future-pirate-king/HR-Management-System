package com.project.hrmanagement.service;

import com.project.hrmanagement.model.TimeSheet;

public interface IEmployeeTimesheetService {
	
	public TimeSheet addTimeSheet(TimeSheet timeSheet);
	public Integer editTimeSheet(TimeSheet timeSheet);
	public Integer updateTimeSheetStatus(TimeSheet timeSheet);
	public Integer rejectTimeSheet(TimeSheet timeSheet);

}
