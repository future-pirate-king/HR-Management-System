package com.project.hrmanagement.Dao;

import com.project.hrmanagement.model.TimeSheet;

public interface IEmployeeTimeSheetDao {

	
	public TimeSheet addTimeSheet(TimeSheet timeSheet);
	public void deleteTimeSheet();
	public TimeSheet editTimeSheet(TimeSheet timeSheet);

}
