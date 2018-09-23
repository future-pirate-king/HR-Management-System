app.config([
  '$stateProvider',
  function($stateProvider) {
    $stateProvider
      .state({
        name: 'login',
        url: '/l',
        component: 'loginComponent'
      })
      .state({
        name: 'home',
        url: '/home',
        component: 'homeComponent'
      })
      .state({
        name: 'timesheet',
        url: '',
        component: 'timesheetComponent'
      });
  }
]);
