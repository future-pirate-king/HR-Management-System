app.service('loginService', function($http) {
  this.login = function(empId, password) {
    return $http.post('http://localhost:9000/test-server/authenticate', {
      empId: empId,
      password: password
    });
  };
});