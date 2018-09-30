app.service('employeeService', function ($http) {
  this.getEmployeeById = function (empId) {
    return $http.get(
      'http://localhost:9000/backend-server/Employee/getEmployee?empId=' + empId
    );
  };

  this.addEmployee = function (employee) {

    return $http.post('http://localhost:9000/backend-server/Employee/addEmployee', {
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
      reportingTo: employee.reportingTo,
      employeeAddress: {
        city: employee.employeeAddress.city,
        state: employee.employeeAddress.state,
        country: employee.employeeAddress.country,
        zipcode: employee.employeeAddress.zipcode,
        street: employee.employeeAddress.street,
      }
    })
  }

  this.getAllEmployees = function () {
    return $http.get('http://localhost:9000/backend-server/Employee/getAllEmployees');
  }

  this.deleteEmployee = function (empId) {
    return $http.delete('http://localhost:9000/backend-server/Employee/removeEmployee?empId=' + empId);
  }
});
