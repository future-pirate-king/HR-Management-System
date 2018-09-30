app.component('addEmployeeComponent', {
  bindings: {},
  templateUrl:
    './src/components/add-employee-component/addEmployee.component.html',
  controller: addEmployeeController
});

function addEmployeeController(employeeService, $mdToast) {
  var $ctrl = this;
  $ctrl.employee = {
    firstName: '',
    middleName: '',
    employeeAddress: {
      street: '',
      city: '',
      state: '',
      zipcode: '',
      country: ''
    },
    lastName: '',
    bloodGroup: 'B+',
    gender: 'Male',
    email: '',
    mobileNo: '',
    cadre: '',
    dateOfJoining: new Date(),
    bdate: new Date('24-FEB-1996'),
    deptName: '',
    reportingTo: ''
  };

  $ctrl.addEmployee = event => {
    event.preventDefault();
    $ctrl.isloading = true;
    employeeService
      .addEmployee($ctrl.employee)
      .then(res => {
        console.log(res);
        $mdToast.show(
          $mdToast
            .simple()
            .textContent('Employee Added Successfully.')
            .position('top right')
            .hideDelay(3000)
        );
        $ctrl.isloading = false;
      })
      .catch(err => {
        console.log(err);
        $ctrl.isloading = false;
      });
  };
}
