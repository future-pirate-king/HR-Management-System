app.component('employeeComponent', {
    bindings: {},
    templateUrl: './src/components/employee-component/employee.component.html',
    controller: employeeController
});

function employeeController(employeeService) {
    var $ctrl = this;

    $ctrl.employeeList = [];
    $ctrl.employee = {};
    $ctrl.showEmployeeForm = false;
    $ctrl.btnName = 'Add Employee';

    this.$onInit = function () {
        employeeService.getAllEmployees()
            .then((res) => {
                $ctrl.employeeList = res.data;
                $ctrl.showDetails(res.data[0]);
                //$ctrl.employee = $ctrl.employeeList[0]
            })
    }

    $ctrl.toggleAddEmployee = function () {
        $ctrl.showEmployeeForm = !$ctrl.showEmployeeForm;
        $ctrl.btnName = $ctrl.showEmployeeForm ? 'Cancel' : 'Add Employee';
    }

    $ctrl.showDetails = function (employee) {
        $ctrl.employee = employee;

        if ($ctrl.showEmployeeForm) {
            $ctrl.showEmployeeForm = !$ctrl.showEmployeeForm;
            $ctrl.btnName = 'Add Employee';
        }
    }
}