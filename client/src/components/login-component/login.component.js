app.component('loginComponent', {
  bindings: {},
  templateUrl: './src/components/login-component/login.component.html',
  controller: loginController
});

function loginController($state) {
  var $ctrl = this;

  $ctrl.passwordInputType = 'password';
  $ctrl.passwordToggleIcon = 'fas fa-eye-slash';

  $ctrl.empId = '';
  $ctrl.password = '';

  $ctrl.login = function() {
    if ($ctrl.empId === '10653184' && $ctrl.password === 'sam') {
      $state.go('home');

      $ctrl.empId = '';
      $ctrl.password = '';
    }
  };

  $ctrl.togglePasswordInputType = function() {
    $ctrl.passwordInputType =
      $ctrl.passwordInputType === 'text' ? 'password' : 'text';
    $ctrl.passwordToggleIcon =
      $ctrl.passwordInputType === 'text' ? 'fas fa-eye' : 'fas fa-eye-slash';
  };
}
