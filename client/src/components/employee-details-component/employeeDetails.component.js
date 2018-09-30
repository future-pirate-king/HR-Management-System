app.component('employeeDetailsComponent', {
  bindings: {
    employee: '<',
    view: '<'
  },
  templateUrl:
    './src/components/employee-details-component/employeeDetails.component.html',
  controller: employeeDetailsController
});

function employeeDetailsController(
  employeeService,
  $mdToast,
  timesheetService,
  $stateParams
) {
  $ctrl = this;
  $ctrl.timesheetList = [];

  this.$onInit = function() {
    $ctrl.initTimesheet();
  };

  $ctrl.initTimesheet = function() {
    timesheetService
      .getEmployeeTimesheetDetails($stateParams.empId)
      .then(res => {
        $ctrl.timesheetList = res.data;
      });
  };

  $ctrl.rejectTimesheet = function(timesheet) {
    timesheetService
      .rejectTimesheet(timesheet)
      .then(res => $ctrl.initTimesheet());
  };

  $ctrl.acceptTimesheet = function(timesheet) {
    timesheetService
      .acceptTimesheet(timesheet)
      .then(res => $ctrl.initTimesheet());
  };

  $ctrl.deleteEmployee = function() {
    employeeService
      .deleteEmployee($ctrl.employee.empId)
      .then(res => {
        console.log(res);
        if (res.data) {
          $mdToast.show(
            $mdToast
              .simple()
              .textContent('Employee deleted.')
              .position('top right')
              .hideDelay(3000)
          );
        } else {
          $mdToast.show(
            $mdToast
              .simple()
              .textContent('Employee does not exists')
              .position('top right')
              .hideDelay(3000)
          );
        }
      })
      .catch(err => console.log(err));
  };
}
