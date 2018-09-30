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
  $ctrl.totalTime = null;
  $scope.startDate = null;
  $scope.endDate = null;
  $ctrl.series = ['Hours Worked'];
  $ctrl.data = [];

  this.$onInit = function() {
    $ctrl.initData();
    var currentWeekStartEndDates = new Date().getWeek();
    timesheetService
      .getTimeSheetDetails(
        currentWeekStartEndDates[0].getTime(),
        currentWeekStartEndDates[1].getTime(),
        $stateParams.empId
      )
      .then(res => {
        $ctrl.taskList = res.data;

        $ctrl.taskList.map(data => {
          $ctrl.calculateTotalTime(
            data.swipeIn,
            data.swipeOut,
            new Date(data.taskDate).getDay()
          );
        });
      });
  };

  $ctrl.calculateTotalTime = function(swipeIn, swipeOut, dayIndex) {
    var swipeInHours = swipeIn / (1000 * 60 * 60);
    var swipeOutHours = swipeOut / (1000 * 60 * 60);

    $ctrl.totalTime = swipeOutHours - swipeInHours;
    $ctrl.data[dayIndex] = $ctrl.totalTime;
  };

  $ctrl.initData = function() {
    $ctrl.data = [0, 0, 0, 0, 0, 0, 0];
  };

  $ctrl.getTimesheetDetails = function() {
    $ctrl.initData();
    timesheetService
      .getTimeSheetDetails($scope.startDate, $scope.endDate, $stateParams.empId)
      .then(res => {
        $ctrl.taskList = res.data;
        $ctrl.taskList.map(data => {
          $ctrl.calculateTotalTime(
            data.swipeIn,
            data.swipeOut,
            new Date(data.taskDate).getDay()
          );
        });
      });
  };

  $ctrl.addTask = function(event) {
    $mdDialog.show({
      controller: DialogController,
      templateUrl: './src/dialogs/timesheet.addtask.html',
      parent: angular.element(document.body),
      targetEvent: event,
      locals: {
        date: $scope.day
      },
      clickOutsideToClose: false,
      fullscreen: false // Only for -xs, -sm breakpoints.
    });
  };
}

Date.prototype.getWeek = function(start) {
  //Calcing the starting point
  start = start || 0;
  var today = new Date(this.setHours(0, 0, 0, 0));
  var day = today.getDay() - start;
  var date = today.getDate() - day;

  // Grabbing Start/End Dates
  var StartDate = new Date(today.setDate(date));
  var EndDate = new Date(today.setDate(date + 6));
  return [StartDate, EndDate];
};

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
