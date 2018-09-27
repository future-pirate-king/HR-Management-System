app.service('employeeService', function ($http) {
  this.getEmployeeById = function (empId) {
    return $http.get(
      'http://localhost:9000/test-server/Employee/getEmployee?empId=' + empId
    );
  };

  this.addEmployee = function (employee) {
    return $http.post('http://localhost:9000/test-server/Employee/addEmployee', {
      firstName: employee.firstName,
      middleName: employee.middleName,
      lastName: employee.lastName,
      bloodGroup: employee.bloodGroup,
      gender: employee.gender,
      email: employee.email,
      mobileNo: employee.mobileNo,
      cadre: employee.cadre,
      dateOfJoining: employee.dateOfJoining,
      bdate: employee.bdate,
      deptName: employee.deptName,
      reportingTo: employee.reportingTo
    })
  }

  this.getAllEmployees = function () {
    return $http.get('http://localhost:9000/test-server/Employee/getAllEmployees');
  }

  this.deleteEmployee = function (empId) {
    return $http.delete('http://localhost:9000/test-server/Employee/removeEmployee?empId=' + empId);
  }
});
