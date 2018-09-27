app.component('employeeDetailsComponent', {
  bindings: {
    employee: '<'
  },
  templateUrl:
    './src/components/employee-details-component/employeeDetails.component.html',
  controller: employeeDetailsController
});

function employeeDetailsController(employeeService, $mdToast) {
  $ctrl = this;

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
