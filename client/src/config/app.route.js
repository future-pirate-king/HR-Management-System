app.config([
  '$stateProvider',
  function($stateProvider) {
    $stateProvider
      .state({
        name: 'login',
        url: '',
        component: 'loginComponent'
      })
      .state({
        name: 'home',
        url: '/home',
        component: 'homeComponent'
      })
      .state({
        name: 'timesheet',
        url: '/timesheet',
        component: 'timesheetComponent'
      });
  }
]);
