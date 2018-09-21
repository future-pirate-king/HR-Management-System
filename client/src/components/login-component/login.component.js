app.component('loginComponent', {
  bindings: {},
  templateUrl: './src/components/login-component/login.component.html',
  controller: loginController
});

function loginController($state, loginService) {
  var $ctrl = this;

  $ctrl.passwordInputType = 'password';
  $ctrl.passwordToggleIcon = 'fas fa-eye-slash';
  $ctrl.tooltipMessage = 'show password';

  $ctrl.empId = '';
  $ctrl.password = '';

  $ctrl.login = function() {
    loginService
      .login($ctrl.empId, $ctrl.password)
      .then(response => console.log(response));
  };

  $ctrl.togglePasswordInputType = function() {
    $ctrl.passwordInputType =
      $ctrl.passwordInputType === 'text' ? 'password' : 'text';
    $ctrl.passwordToggleIcon =
      $ctrl.passwordInputType === 'text' ? 'fas fa-eye' : 'fas fa-eye-slash';
    $ctrl.tooltipMessage =
      $ctrl.passwordInputType === 'text' ? 'hide password' : 'show password';
  };
}
