package com.Bluering.Employee.Management.System.Service;


import com.Bluering.Employee.Management.System.Model.ExpenseClaim;
import com.Bluering.Employee.Management.System.Repository.ExpenseClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpenseClaimServiceImpl extends ExpenseClaimService {

    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;

    @Override
    public Page<ExpenseClaim> getExpenseClaimByTypeId(Long typeId, Pageable pageable) {
        return expenseClaimRepository.findByExpenseType_Id(typeId, pageable);
    }

}
