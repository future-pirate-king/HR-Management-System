app.service('employeeService', function ($http) {
  this.getEmployeeById = function (empId) {
    return $http.get(
      'http://localhost:9000/test-server/Employee/getEmployee?empId=' + empId
    );
  };
});
