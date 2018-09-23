app.component('calenderComponent', {
  bindings: {},
  templateUrl: './src/components/calender-component/calender.component.html',
  controller: calenderController
});

function calenderController($mdDialog) {
  var $ctrl = this;
  $ctrl.dayNames = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

  $ctrl.monthNames = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December'
  ];

  $ctrl.series = ['Hours Worked'];

  $ctrl.data = [10];

  $ctrl.date = new Date();
  $ctrl.month = $ctrl.date.getMonth(); //0-1
  $ctrl.year = $ctrl.date.getFullYear(); //2018
  var firstDate = $ctrl.monthNames[$ctrl.month] + ' ' + 1 + ' ' + $ctrl.year;
  //September 1 2014

  var temp = new Date(firstDate).toDateString(); //Mon Sep 01 2014 ...
  var firstDay = temp.substring(0, 3);
  $ctrl.dayNo = 7; //$ctrl.dayNames.indexOf(firstDay); // 1

  $ctrl.days = new Date($ctrl.year, $ctrl.month + 1, 0).getDate(); // total days

  $ctrl.addTask = function(event) {
    $mdDialog
      .show({
        controller: DialogController,
        templateUrl: './src/dialogs/timesheet.addtask.html',
        parent: angular.element(document.body),
        targetEvent: event,
        clickOutsideToClose: true,
        fullscreen: false // Only for -xs, -sm breakpoints.
      })
      .then(
        function(formData) {
          $ctrl.formData = formData;
        },
        function() {} //fires when dialog closed
      );
  };
}

function DialogController($scope, $mdDialog) {
  $scope.hide = function() {
    $mdDialog.hide();
  };

  $scope.cancel = function() {
    $mdDialog.cancel();
  };

  $scope.answer = function(event, answer) {
    event.preventDefault();
    $mdDialog.hide(answer);
  };
}
