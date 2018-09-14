app.config([
  '$stateProvider',
  function($stateProvider) {
    $stateProvider.state({
      name: 'login',
      url: '*path',
      component: 'loginComponent'
    });
  }
]);
