package com.Bluering.Employee.Management.System.Controller;


import com.Bluering.Employee.Management.System.Model.Employee;
import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Model.ExpenseTypeClaim;
import com.Bluering.Employee.Management.System.Service.ExpenseTypeClaimService;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense-type-claims")
public class ExpenseTypeClaimController {
    private final ExpenseTypeClaimService expenseTypeClaimService;

    public ExpenseTypeClaimController(ExpenseTypeClaimService expenseTypeClaimService) {
        this.expenseTypeClaimService = expenseTypeClaimService;
    }

    @PostMapping
    public ExpenseTypeClaim createExpenseTypeClaim(@RequestBody ExpenseTypeClaim expenseTypeClaim) {
        return expenseTypeClaimService.createExpenseTypeClaim(expenseTypeClaim);
    }

    @GetMapping("/{employeeId}/{expenseTypeId}")
    public List<ExpenseTypeClaim> getExpenseTypeClaims(@PathVariable Long employeeId, @PathVariable Long expenseTypeId) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        ExpenseType expenseType = new ExpenseType();
        expenseType.setId(expenseTypeId);
        return expenseTypeClaimService.getExpenseTypeClaims(employee, expenseType);
    }
}
