package com.Bluering.Employee.Management.System.Service;

import com.Bluering.Employee.Management.System.Model.Department;
import com.Bluering.Employee.Management.System.Model.Employee;
import com.Bluering.Employee.Management.System.Repository.DepartmentRepository;
import com.Bluering.Employee.Management.System.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Department createDepartment() {
        return departmentRepository.save(department);
    }

    @Override
    public List<Employee> addEmployeesToDepartment(Long departmentId, List<Employee> employees) {
        return null;
    }

    @Override
    public List<Employee> addEmployeesToDepartment(Long departmentId, List<Employee> employees) {
        Department department = departmentRepository.getById(departmentId);
        for (Employee employee : employees) {
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Department createDepartment() {
        return createDepartment();
    }

    @Override
    public Department createDepartment(Department department) {
        return null;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }


    //assigning employees to departments
    @Override
    public List<Employee> assignEmployeesToDepartment(Long departmentId, List<Long> employeeIds) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Department not found"));

        List<Employee> employees = employeeRepository.findAllById(employeeIds);
        for (Employee employee : employees) {
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }

        return employees;
    }

}

