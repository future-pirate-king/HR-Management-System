app.service('timesheetService', function ($http) {
  this.addTask = function (empId, swipeIn, swipeOut, taskDate, taskName) {
    return $http.post('http://localhost:9000/backend-server/timesheet/addTask', {
      empId: empId,
      swipeIn: swipeIn,
      swipeOut: swipeOut,
      taskDate: taskDate,
      taskName: taskName
    });
  };

  this.getTimeSheetDetails = function (startDate, endDate, empId) {

    return $http.get('http://localhost:9000/backend-server/timesheet/findTimeSheetDetails?empId=' + empId + '&startDate=' + startDate + '&endDate=' + endDate);
  }

  this.getEmployeeTimesheetDetails = function (empId) {
    return $http.get('http://localhost:9000/backend-server/timesheet/getEmployeeTimeSheets?empId=' + empId)
  }

  this.rejectTimesheet = function (timesheet) {
    return $http.post('http://localhost:9000/backend-server/timesheet/rejectTimeSheet', {
      empId: timesheet.empId,
      taskDate: timesheet.taskDate,
      taskName: timesheet.taskName,
      swipeIn: timesheet.swipeIn,
      swipeOut: timesheet.swipeOut,
      isFilled: timesheet.isFilled,
      isApproved: timesheet.isApproved,
      timeSheetId: timesheet.timeSheetId
    })
  }


  this.acceptTimesheet = function (timesheet) {
    return $http.post('http://localhost:9000/backend-server/timesheet/updateStatus', {
      empId: timesheet.empId,
      taskDate: timesheet.taskDate,
      taskName: timesheet.taskName,
      swipeIn: timesheet.swipeIn,
      swipeOut: timesheet.swipeOut,
      isFilled: timesheet.isFilled,
      isApproved: timesheet.isApproved,
      timeSheetId: timesheet.timeSheetId
    })

  }
});
