package com.Bluering.Employee.Management.System.Service;

import com.Bluering.Employee.Management.System.Model.Department;
import com.Bluering.Employee.Management.System.Model.Employee;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Employee> addEmployeesToDepartment(Long departmentId, List<Employee> employees);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByDepartmentId(Long departmentId);

    //assign employees to departments
    List<Employee> assignEmployeesToDepartment(Long departmentId, List<Long> employeeIds);

}
