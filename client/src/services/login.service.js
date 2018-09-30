app.service('loginService', function ($http) {
  this.login = function (empId, password) {
    return $http.post(
      'http://localhost:9000/backend-server/LoginIn/authenticate',
      {
        empId: empId,
        password: password
      }
    );
  };

  this.otpGen = function (empId) {
    return $http.post('http://localhost:9000/backend-server/LoginIn/otpgen?empId=' + empId);
  }

  this.resetPassword = function (empId, OTP, password) {
    return $http.post('http://localhost:9000/backend-server/LoginIn/resetPassword?empId=' + empId + '&OTP=' + OTP + '&password=' + password);
  }
});
