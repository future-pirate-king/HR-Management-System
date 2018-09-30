app.component('mainAreaComponent', {
  bindings: {},
  templateUrl: './src/components/main-area-component/main-area.component.html',
  controller: mainAreaController
});

function mainAreaController(
  announcementService,
  employeeService,
  timesheetService,
  $stateParams
) {
  var $ctrl = this;

  $ctrl.announcementList = [];
  $ctrl.timesheetPendingDates = [];
  $ctrl.status = '';

  $ctrl.timesheetLink = 'home.timesheet({empId:' + $stateParams.empId + '})';
  $ctrl.complaintLink = 'home.complaint({empId:' + $stateParams.empId + '})';
  $ctrl.payrollLink = 'home.payroll({empId:' + $stateParams.empId + '})';

  this.$onInit = function() {
    employeeService
      .getEmployeeById($stateParams.empId)
      .then(res => ($ctrl.lastLogin = res.data.lastLogin));
    $ctrl.getTimesheetDetails();
    announcementService
      .getAllAnnouncements()
      .then(res => ($ctrl.announcementList = res.data));
  };

  $ctrl.getTimesheetDetails = function() {
    var date = new Date();
    var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
    var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);

    timesheetService
      .getTimeSheetDetails(
        firstDay.getTime(),
        lastDay.getTime(),
        $stateParams.empId
      )
      .then(res => {
        var data = res.data;
        data.map(fd => {
          if (fd.isApproved === 0) {
            $ctrl.status = 'PENDING';
          } else if (fd.isApproved === 1) {
            $ctrl.status = 'APPROVED';
          } else {
            $ctrl.status = 'REJECTED';
          }

          var details = {
            taskName: fd.taskName,
            taskDate: fd.taskDate,
            status: $ctrl.status
          };
          $ctrl.timesheetPendingDates.push(details);
        });
      });
  };
}
