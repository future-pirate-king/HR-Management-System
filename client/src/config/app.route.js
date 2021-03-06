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
        name: 'profile',
        url: '/profile/{empId}',
        component: 'profileComponent'
      })
      .state({
        name: 'hr_home',
        url: '/hr/{empId}',
        component: 'hrHomeComponent'
      })
      .state({
        name: 'hr_home.employee',
        url: '/employee',
        component: 'employeeComponent'
      })
      .state({
        name: 'hr_home.announcement',
        url: '/announcement',
        component: 'addAnnouncementComponent'
      })
      .state({
        name: 'hr_home.complaint',
        url: '/complaints',
        component: 'complaintListComponent'
      })
      .state({
        name: 'hr_home.feedback',
        url: '/feedbacks',
        component: 'feedbackListComponent'
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
      })
      .state({
        name: 'home.feedback',
        url: '/feedback',
        component: 'feedbackComponent'
      })
      .state({
        name: 'home.payroll',
        url: '/payroll',
        component: 'payrollComponent'
      });
  }
]);
