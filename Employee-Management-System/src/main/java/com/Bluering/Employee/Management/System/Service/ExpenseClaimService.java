package com.Bluering.Employee.Management.System.Service;


import com.Bluering.Employee.Management.System.Model.ExpenseClaim;
import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Repository.ExpenseClaimRepository;
import com.Bluering.Employee.Management.System.Repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseClaimService {

    public Page<ExpenseClaim> getExpenseClaimByTypeId(Long typeId, Pageable pageable) {
        return expenseClaimRepository.findByExpenseTypeId(typeId, pageable);
    }

    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;

    public List<ExpenseClaim> getAllExpenseClaims() {
        return expenseClaimRepository.findAll();
    }

    public ExpenseClaim getExpenseClaimById(Long id, PageRequest paging) {
        return expenseClaimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));
    }

    public ExpenseClaim createExpenseClaim(ExpenseClaim expenseClaim) {
        return expenseClaimRepository.save(expenseClaim);
    }

    public ExpenseClaim updateExpenseClaim(Long id, ExpenseClaim expenseClaimDetails) {
        ExpenseClaim expenseClaim = expenseClaimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));

        expenseClaim.setDescription(expenseClaimDetails.getDescription());
        expenseClaim.setAmount(expenseClaimDetails.getAmount());

        return expenseClaimRepository.save(expenseClaim);
    }

    public void deleteExpenseClaim(Long id) {
        ExpenseClaim expenseClaim = expenseClaimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim", "id", id));
        expenseClaimRepository.delete(expenseClaim);
    }

    public BigDecimal getTotalExpenseClaimAmountByExpenseType(Long typeId) {
        public BigDecimal getTotalExpenseClaimAmountByExpenseType(Long typeId) {
            ExpenseType expenseType = ExpenseTypeRepository.findById(typeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Expense type not found"));

            BigDecimal totalAmount = expenseClaimRepository.getTotalAmountByExpenseType(expenseType);

            if (totalAmount == null) {
                return BigDecimal.ZERO;
            }

            return totalAmount;
        }

    }
}


//@Service
//public class ExpenseClaimService {
//    private final ExpenseClaimRepository expenseClaimRepository;
//
//    public ExpenseClaimService(ExpenseClaimRepository expenseClaimRepository) {
//        this.expenseClaimRepository = expenseClaimRepository;
//    }
//
//    public ExpenseClaim createExpenseClaim(ExpenseClaim expenseClaim) {
//        return expenseClaimRepository.save(expenseClaim);
//    }
//}


