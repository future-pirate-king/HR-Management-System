app.service('timesheetService', function($http) {
  this.addTask = function(empId, swipeIn, swipeOut, taskDate, taskName) {
    return $http.post('http://localhost:9000/test-server/timesheet/addTask', {
      empId: empId,
      swipeIn: swipeIn,
      swipeOut: swipeOut,
      taskDate: taskDate,
      taskName: taskName
    });
  };
});
