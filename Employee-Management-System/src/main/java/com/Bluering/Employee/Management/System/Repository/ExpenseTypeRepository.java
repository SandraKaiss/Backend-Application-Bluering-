package com.Bluering.Employee.Management.System.Repository;

import com.Bluering.Employee.Management.System.Model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
}