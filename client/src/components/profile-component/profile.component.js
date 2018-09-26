app.component('profileComponent', {
  bindings: {},
  templateUrl: './src/components/profile-component/profile.component.html',
  controller: profileController
});

function profileController(employeeService, $stateParams) {
  var $ctrl = this;
  $ctrl.employee = {};

  this.$onInit = function () {
    employeeService.getEmployeeById($stateParams.empId).then((res) => {
      $ctrl.employee = res.data;
    });
  }
}
