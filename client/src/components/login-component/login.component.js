app.component('loginComponent', {
  bindings: {},
  templateUrl: './src/components/login-component/login.component.html',
  controller: loginController
});

function loginController($state, loginService, $mdToast, $mdDialog) {
  var $ctrl = this;

  $ctrl.passwordInputType = 'password';
  $ctrl.passwordToggleIcon = 'fas fa-eye-slash';
  $ctrl.tooltipMessage = 'show password';

  $ctrl.empId = '';
  $ctrl.password = '';

  $ctrl.forgotPassword = function (event) {
    $mdDialog.show({
      controller: PasswordResetController,
      templateUrl: './src/dialogs/password.reset.html',
      parent: angular.element(document.body),
      targetEvent: event,
      clickOutsideToClose: false,
      fullscreen: false
    })
      .then(function (result) {

      }, function () {

      });
  }

  $ctrl.login = function () {
    $ctrl.isloading = true;

    loginService
      .login($ctrl.empId, $ctrl.password)
      .then(response => {
        if (response.data) {
          $state.go('home', { empId: response.data.empId }, { notify: false, location: 'replace' });
        } else {
          $mdToast.show(
            $mdToast
              .simple()
              .textContent('Enter valid a email and password.')
              .position('top right')
              .hideDelay(3000)
          );
        }

        $ctrl.isloading = false;
      })
      .catch(err => {
        console.log(err);
        $ctrl.isloading = false;
      });
  };

  $ctrl.togglePasswordInputType = function () {
    $ctrl.passwordInputType =
      $ctrl.passwordInputType === 'text' ? 'password' : 'text';
    $ctrl.passwordToggleIcon =
      $ctrl.passwordInputType === 'text' ? 'fas fa-eye' : 'fas fa-eye-slash';
    $ctrl.tooltipMessage =
      $ctrl.passwordInputType === 'text' ? 'hide password' : 'show password';
  };
}

function PasswordResetController($scope, $mdDialog, loginService, $mdToast) {

  $scope.empId = '';
  $scope.loading = false;
  $scope.message = '';
  $scope.OTP = '';
  $scope.password = '';

  $scope.genOTP = true;
  $scope.resetPassword = false;

  $scope.hide = function () {
    $mdDialog.hide();
  };

  $scope.cancel = function () {
    $mdDialog.cancel();
  };

  $scope.sendOTP = function (empId) {
    $scope.loading = true;
    loginService.otpGen(empId)
      .then(res => {
        if (res.data) {
          $scope.message = 'OTP sent to your registered Email Id.'
          $scope.empId = empId;
          $scope.genOTP = false;
          $scope.resetPassword = true;
        }
        $scope.loading = false;
      })
      .catch(err => {
        $scope.message = 'OTP not generated, Please Contact your HR.'
        $scope.loading = false;
      });
  };

  $scope.changePassword = function (OTP, password) {
    console.log($scope.empId, OTP, password)
    loginService.resetPassword($scope.empId, OTP, password)
      .then(res => console.log(res));
  }
}