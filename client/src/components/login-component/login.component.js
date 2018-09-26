app.component('loginComponent', {
  bindings: {},
  templateUrl: './src/components/login-component/login.component.html',
  controller: loginController
});

function loginController($state, loginService, $mdToast) {
  var $ctrl = this;

  $ctrl.passwordInputType = 'password';
  $ctrl.passwordToggleIcon = 'fas fa-eye-slash';
  $ctrl.tooltipMessage = 'show password';

  $ctrl.empId = '';
  $ctrl.password = '';

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
