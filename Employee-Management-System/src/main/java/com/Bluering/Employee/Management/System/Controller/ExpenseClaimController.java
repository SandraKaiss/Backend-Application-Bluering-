
package com.Bluering.Employee.Management.System.Controller;

import com.Bluering.Employee.Management.System.Model.ExpenseClaim;
import com.Bluering.Employee.Management.System.Repository.ExpenseClaimRepository;
import com.Bluering.Employee.Management.System.Service.ExpenseClaimService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/expenseClaims")
public class ExpenseClaimController {

    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;
    private ExpenseClaim expenseClaim;

    @GetMapping
    public java.util.List<ExpenseClaim> getAllExpenseClaims() {
        return expenseClaimRepository.findAll();
    }

    @GetMapping("/{id}")
    public ExpenseClaim getExpenseClaimById(@PathVariable Long id) {
        return expenseClaimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));
    }

    @PostMapping
    public ExpenseClaim createExpenseClaim(@RequestBody ExpenseClaim expenseClaim) {
        return expenseClaimRepository.save(expenseClaim);
    }


    @PutMapping("/{id}")
    public ExpenseClaim updateExpenseClaim(@PathVariable Long id, @RequestBody ExpenseClaim expenseClaimDetails) {
        ExpenseClaim expenseClaim = expenseClaimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));

        expenseClaim.setDate(expenseClaimDetails.getDate());
        expenseClaim.setDescription(expenseClaimDetails.getDescription());
        expenseClaim.setTotal(expenseClaimDetails.getTotal());
        expenseClaim.setStatus(expenseClaimDetails.getStatus());

        return expenseClaimRepository.save(expenseClaim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpenseClaim(@PathVariable Long id) {
        ExpenseClaim expenseClaim = expenseClaimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));

        expenseClaimRepository.delete(expenseClaim);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/total-claims-per-type-per-employee")
    public Map<String, Map<String, BigDecimal>> getTotalClaimsPerTypePerEmployee() {
        List<ExpenseClaim> expenseClaims = expenseClaimRepository.findAll();
        Map<String, Map<String, BigDecimal>> result = new HashMap<>();

        for (ExpenseClaim expenseClaim : expenseClaims) {
            String employeeName = expenseClaim.getEmployee().getName();
            String expenseClaimTypeName = expenseClaim.getExpenseClaimType().getName();
            BigDecimal amount = expenseClaim.getAmount();

            if (!result.containsKey(employeeName)) {
                result.put(employeeName, new HashMap<>());
            }

            Map<String, BigDecimal> expenseClaimsByType = result.get(employeeName);

            if (!expenseClaimsByType.containsKey(expenseClaimTypeName)) {
                expenseClaimsByType.put(expenseClaimTypeName, BigDecimal.ZERO);
            }

            BigDecimal totalAmount = expenseClaimsByType.get(expenseClaimTypeName).add(amount);
            expenseClaimsByType.put(expenseClaimTypeName, totalAmount);
        }

        return result;


    public final ExpenseClaimService expenseClaimService;

    public ExpenseClaimController(ExpenseClaimService expenseClaimService) {
        this.ExpenseClaimService = expenseClaimService;
    }

        public ExpenseClaim createExpenseClaim(ExpenseClaim expenseClaim) {
        return expenseClaimService.createExpenseClaim(expenseClaim);
    }
}