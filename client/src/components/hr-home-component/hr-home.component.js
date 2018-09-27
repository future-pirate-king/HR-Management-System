app.component('hrHomeComponent', {
    bindings: {},
    templateUrl: './src/components/hr-home-component/hr-home.component.html',
    controller: hrHomeController,
});

function hrHomeController(employeeService) {
    var $ctrl = this;

    $ctrl.mode = 'hr';

}