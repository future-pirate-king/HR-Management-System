app.component('sidenavComponent', {
  bindings: {},
  templateUrl: './src/components/sidenav-component/sidenav.component.html',
  controller: sidenavController
});

function sidenavController() {
  var $ctrl = this;

  $ctrl.menuItems = [
    {
      icon: 'fas fa-home fa-lg',
      title: 'Home',
      link: 'home'
    },
    {
      icon: 'fas fa-calendar-alt fa-lg',
      title: 'Time Sheet',
      link: 'timeSheet'
    },
    {
      icon: 'fas fa-money-bill-alt fa-lg',
      title: 'Payroll',
      link: 'payroll'
    },
    {
      icon: 'fas fa-comment-dots fa-lg',
      title: 'Complaints',
      link: 'complaints'
    },
    {
      icon: 'fab fa-foursquare fa-lg',
      title: 'Feedback',
      link: 'feedback'
    }
  ];
}
