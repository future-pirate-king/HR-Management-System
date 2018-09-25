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
        url: '/home/{empId}',
        component: 'homeComponent'
      })
      .state({
        name: 'home.dashboard',
        url: '/dashboard',
        component: 'mainAreaComponent'
      })
      .state({
        name: 'home.timesheet',
        url: '/timesheet',
        component: 'timesheetComponent'
      })
      .state({
        name: 'home.complaint',
        url: '/complaint',
        component: 'complaintComponent'
      });
  }
]);
