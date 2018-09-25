app.component('homeComponent', {
  bindings: {},
  templateUrl: './src/components/home-component/home.component.html',
  controller: homeController
});

function homeController($state, $stateParams) {
  this.$onInit = function() {
    $state.go(
      'home.dashboard',
      { empId: $stateParams.empId },
      { notify: false, location: 'replace' }
    );
  };
}
