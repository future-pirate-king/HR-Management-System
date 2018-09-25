package com.project.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.TimeSheet;
import com.project.hrmanagement.service.IEmployeeTimesheetService;


//----------working------------//
//add task by employee   (working completely with aungular and json obj) no changes req!!
//update task by employee  (working completely with aungular and json obj) no changes req!!
//update status of time sheet by HR i.e approval (working completely with aungular and json obj) no changes req!!
//reject timesheet by HR  (working completely with aungular and json obj) no changes req!!


@RestController
@RequestMapping("/timesheet")
public class EmployeeTimeSheetController {

	@Autowired

	private IEmployeeTimesheetService employeeTimeSheetService;

	// Add new task to timeSheet used by employee
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public TimeSheet addTimeSheet(@RequestBody TimeSheet timeSheet) {
		System.out.println(timeSheet.getTaskDate());

		return employeeTimeSheetService.addTimeSheet(timeSheet);
	}

	// update an already existing task to timeSheet used by employee
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public Integer editTimeSheet(@RequestBody TimeSheet timeSheet) {
		/* System.out.println(timeSheet.getTaskDate()); */

		return employeeTimeSheetService.editTimeSheet(timeSheet);
	}

	// update approval status of timesheet only used by HR
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public Integer updateStatus(@RequestBody TimeSheet timeSheet) {
		/* System.out.println(timeSheet.getTaskDate()); */

		return employeeTimeSheetService.updateTimeSheetStatus(timeSheet);

	}

	// reject timeSheet by setting approval flag to null, only used by HR
	@RequestMapping(value = "/rejectTimeSheet", method = RequestMethod.POST)
	public Integer rejectTimeSheet(@RequestBody TimeSheet timeSheet) {

		return employeeTimeSheetService.rejectTimeSheet(timeSheet);

	}

	public IEmployeeTimesheetService getEmployeeTimeSheetService() {
		return employeeTimeSheetService;
	}

	public void setEmployeeTimeSheetService(IEmployeeTimesheetService employeeTimeSheetService) {
		this.employeeTimeSheetService = employeeTimeSheetService;
	}

}
