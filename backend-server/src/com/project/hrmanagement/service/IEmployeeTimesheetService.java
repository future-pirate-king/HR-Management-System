package com.project.hrmanagement.service;

import com.project.hrmanagement.model.TimeSheet;

public interface IEmployeeTimesheetService {
	
	public TimeSheet addTimeSheet(TimeSheet timeSheet);
	public TimeSheet editTimeSheet(TimeSheet timeSheet);
	public TimeSheet rejectTimeSheet(TimeSheet timeSheet);
	public TimeSheet approveTimeSheet(TimeSheet timeSheet);
	public TimeSheet requestApprovalTimeSheet(TimeSheet timeSheet);

}
