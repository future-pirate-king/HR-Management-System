app.component('timesheetComponent', {
  bindings: {},
  templateUrl: './src/components/timesheet-component/timesheet.component.html',
  controller: timesheetController
});

function timesheetController(
  $scope,
  $mdDialog,
  $stateParams,
  timesheetService
) {
  var $ctrl = this;
  $ctrl.dayNames = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
  $scope.day = moment();
  $ctrl.taskList = [];
  $scope.startDate = null;
  $scope.endDate = null;

  $ctrl.onInit = function() {
    // getTimesheetDetails goes here..
  };

  $ctrl.series = ['Hours Worked'];

  $ctrl.data = [10];

  $ctrl.getTimesheetDetails = function() {
    timesheetService
      .getTimeSheetDetails($scope.startDate, $scope.endDate, $stateParams.empId)
      .then(res => {
        $ctrl.taskList = res.data;
      });
  };

  $ctrl.addTask = function(event) {
    $mdDialog
      .show({
        controller: DialogController,
        templateUrl: './src/dialogs/timesheet.addtask.html',
        parent: angular.element(document.body),
        targetEvent: event,
        locals: {
          date: $scope.day
        },
        clickOutsideToClose: true,
        fullscreen: false // Only for -xs, -sm breakpoints.
      })
      .then(data => $ctrl.taskList.push(data));
  };
}

function DialogController(
  $scope,
  $mdDialog,
  date,
  timesheetService,
  $stateParams,
  $mdToast
) {
  $scope.date = date;

  $scope.timesheet = {
    swipeOut: null,
    swipeIn: null,
    taskDate: $scope.date,
    taskName: ''
  };

  $scope.hide = function() {
    $mdDialog.hide();
  };

  $scope.cancel = function() {
    $mdDialog.cancel();
  };

  $scope.answer = function(event, formData) {
    event.preventDefault();

    timesheetService
      .addTask(
        $stateParams.empId,
        $scope.timesheet.swipeIn.getTime(),
        $scope.timesheet.swipeOut.getTime(),
        $scope.date._d.getTime(),
        $scope.timesheet.taskName
      )
      .then(res => {
        $mdToast.show(
          $mdToast
            .simple()
            .textContent('Task Added Successfully.')
            .position('top right')
            .hideDelay(3000)
        );
        $mdDialog.hide(res.data);
      });
  };
}
