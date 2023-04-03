package com.Bluering.Employee.Management.System.Controller;


import com.Bluering.Employee.Management.System.Model.Department;
import com.Bluering.Employee.Management.System.Model.Employee;
import com.Bluering.Employee.Management.System.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PostMapping("/{departmentId}/employees")
    public ResponseEntity<List<Employee>> addEmployeesToDepartment(@PathVariable Long departmentId, @RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = departmentService.addEmployeesToDepartment(departmentId, employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        employee.setId(employeeId);
        Employee updatedEmployee = departmentService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        List<Employee> employees = departmentService.getEmployeesByDepartmentId(departmentId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
