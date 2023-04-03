package com.Bluering.Employee.Management.System.Repository;


import com.Bluering.Employee.Management.System.Model.Employee;
import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Model.ExpenseTypeClaim;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeClaimRepository extends JpaRepository<ExpenseTypeClaim, Long> {
    List<ExpenseTypeClaim> findByEmployeeAndExpenseType(Employee employee, ExpenseType expenseType);
}