package com.project.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.TimeSheet;
import com.project.hrmanagement.service.IEmployeeTimesheetService;

@RestController
public class EmployeeTimeSheetController {

	@Autowired
	private IEmployeeTimesheetService employeeTimeSheetService;

	/*
	 * @RequestMapping(value = "/addTimeSheet" , method = RequestMethod.POST) public
	 * TimeSheet addtimeSheet(@RequestBody TimeSheet timeSheet) {
	 * 
	 * Integer empId = 2;
	 * 
	 * @SuppressWarnings("deprecation") TimeSheet ts = new TimeSheet(empId, new
	 * Date("16-AUG-2017"), "training", 9, 18, 9); return
	 * employeeTimeSheetService.editTimeSheet(timeSheet); }
	 */

	@RequestMapping(value = "/addTimeSheet", method = RequestMethod.POST)
	public TimeSheet addtimeSheet(@RequestBody TimeSheet timeSheet) {

		return employeeTimeSheetService.editTimeSheet(timeSheet);
	}

	public IEmployeeTimesheetService getEmployeeTimeSheetService() {
		return employeeTimeSheetService;
	}

	public void setEmployeeTimeSheetService(IEmployeeTimesheetService employeeTimeSheetService) {
		this.employeeTimeSheetService = employeeTimeSheetService;
	}

}
