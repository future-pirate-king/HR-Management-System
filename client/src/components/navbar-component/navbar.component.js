app.component('navbarComponent', {
  bindings: {
    mode: '<'
  },
  templateUrl: './src/components/navbar-component/navbar.component.html',
  controller: navbarController,
});

function navbarController(employeeService, $state, $stateParams, $mdToast) {

  var $ctrl = this;
  $ctrl.firstName = '';
  $ctrl.lastName = '';
  $ctrl.hrLink = '';

  this.$onInit = function () {
    $ctrl.hrMode = $ctrl.mode === 'hr';
    $ctrl.profileLink = 'profile({empId:' + $stateParams.empId + '})';
    $ctrl.hrLink = 'hr_home({empId:' + $stateParams.empId + '})';

    employeeService.getEmployeeById($stateParams.empId).then((res) => {
      $ctrl.firstName = res.data.firstName;
      $ctrl.lastName = res.data.lastName;
    });
  }
}
