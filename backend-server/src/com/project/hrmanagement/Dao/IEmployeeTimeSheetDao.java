package com.project.hrmanagement.Dao;

import com.project.hrmanagement.model.TimeSheet;

public interface IEmployeeTimeSheetDao {

	

	public TimeSheet addTimeSheet(TimeSheet timeSheet);
	public Integer editTimeSheet(TimeSheet timeSheet);
	public Integer rejectTimeSheet(TimeSheet timeSheet);

	public Integer updateTimeSheetStatus(TimeSheet timeSheet);
}
