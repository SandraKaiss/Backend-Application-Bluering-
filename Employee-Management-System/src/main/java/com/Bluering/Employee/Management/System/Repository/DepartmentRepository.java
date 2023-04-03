package com.Bluering.Employee.Management.System.Repository;


import com.Bluering.Employee.Management.System.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}