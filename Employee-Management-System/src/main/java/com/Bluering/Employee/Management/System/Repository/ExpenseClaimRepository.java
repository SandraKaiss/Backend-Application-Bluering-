package com.Bluering.Employee.Management.System.Repository;


import com.Bluering.Employee.Management.System.Model.ExpenseClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Long> {
}

