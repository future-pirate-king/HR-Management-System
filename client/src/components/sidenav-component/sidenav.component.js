app.component('sidenavComponent', {
  bindings: {},
  templateUrl: './src/components/sidenav-component/sidenav.component.html',
  controller: sidenavController
});

function sidenavController($stateParams) {
  var $ctrl = this;

  $ctrl.menuItems = [
    {
      icon: 'fas fa-home',
      title: 'Home',
      link: 'home.dashboard({empId:' + $stateParams.empId + '})'
    },
    {
      icon: 'fas fa-calendar-alt',
      title: 'Time Sheet',
      link: 'home.timesheet({empId:' + $stateParams.empId + '})'
    },
    {
      icon: 'fas fa-money-bill-alt',
      title: 'Payroll',
      link: 'payroll'
    },
    {
      icon: 'fas fa-comment-dots',
      title: 'Complaints',
      link: 'complaints'
    },
    {
      icon: 'fab fa-foursquare',
      title: 'Feedback',
      link: 'feedback'
    }
  ];
}
