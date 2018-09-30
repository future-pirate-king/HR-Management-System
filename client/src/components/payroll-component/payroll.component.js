app.component('payrollComponent', {
  bindings: {},
  templateUrl: './src/components/payroll-component/payroll.component.html',
  controller: payrollController
});

function payrollController() {
  var $ctrl = this;

  var date = new Date();
  var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
  var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
  var payDay = new Date(date.getFullYear(), date.getMonth() + 1, 28);

  $ctrl.dates = [
    {
      name: 'Start',
      date: firstDay
    },
    {
      name: 'End',
      date: lastDay
    },
    {
      name: 'Pay Day',
      date: payDay
    }
  ];
}
