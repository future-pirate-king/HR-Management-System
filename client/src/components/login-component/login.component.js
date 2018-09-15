app.component('loginComponent', {
  bindings: {},
  templateUrl: './src/components/login-component/login.component.html',
  controller: loginController
});

function loginController() {
  var $ctrl = this;

  $ctrl.passwordInputType = 'password';
  $ctrl.passwordToggleIcon = 'fas fa-eye-slash';

  $ctrl.togglePasswordInputType = function() {
    $ctrl.passwordInputType =
      $ctrl.passwordInputType === 'text' ? 'password' : 'text';
    $ctrl.passwordToggleIcon =
      $ctrl.passwordInputType === 'text' ? 'fas fa-eye' : 'fas fa-eye-slash';
  };
}
