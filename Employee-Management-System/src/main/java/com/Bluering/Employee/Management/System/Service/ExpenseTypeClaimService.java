package com.Bluering.Employee.Management.System.Service;


import com.Bluering.Employee.Management.System.Model.Employee;
import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Model.ExpenseTypeClaim;
import com.Bluering.Employee.Management.System.Repository.ExpenseTypeClaimRepository;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeClaimService {
    private final ExpenseTypeClaimRepository expenseTypeClaimRepository;

    public ExpenseTypeClaimService(ExpenseTypeClaimRepository expenseTypeClaimRepository) {
        this.expenseTypeClaimRepository = expenseTypeClaimRepository;
    }

    public ExpenseTypeClaim createExpenseTypeClaim(ExpenseTypeClaim expenseTypeClaim) {
        return expenseTypeClaimRepository.save(expenseTypeClaim);
    }

    public List<ExpenseTypeClaim> getExpenseTypeClaims(Employee employee, ExpenseType expenseType) {
        return expenseTypeClaimRepository.findByEmployeeAndExpenseType(employee, expenseType);
    }
}