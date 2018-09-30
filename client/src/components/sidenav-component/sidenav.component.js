app.component('sidenavComponent', {
  bindings: {
    mode: '<'
  },
  templateUrl: './src/components/sidenav-component/sidenav.component.html',
  controller: sidenavController
});

function sidenavController($stateParams) {
  var $ctrl = this;

  this.$onInit = function() {
    $ctrl.hrNav = $ctrl.mode === 'hr';
  };

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
      link: 'home.payroll({empId:' + $stateParams.empId + '})'
    },
    {
      icon: 'fas fa-comment-dots',
      title: 'Complaints',
      link: 'home.complaint({empId:' + $stateParams.empId + '})'
    },
    {
      icon: 'fab fa-foursquare',
      title: 'Feedback',
      link: 'home.feedback({empId:' + $stateParams.empId + '})'
    }
  ];

  $ctrl.hrMenuItems = [
    {
      icon: 'fas fa-home',
      title: 'Manage Employee',
      link: 'hr_home.employee()'
    },
    {
      icon: 'fas fa-bullhorn',
      title: 'Add Announcement',
      link: 'hr_home.announcement()'
    },
    {
      icon: 'fas fa-comment-dots',
      title: 'Manage Complaints',
      link: 'hr_home.complaint()'
    },
    {
      icon: 'fab fa-foursquare',
      title: 'Manage Feedback',
      link: 'hr_home.feedback()'
    }
  ];
}
