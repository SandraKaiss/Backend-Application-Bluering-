package com.Bluering.Employee.Management.System.Service;


import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Repository.ExpenseTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeService {
    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public ExpenseType createExpenseType(ExpenseType expenseType) {
        return expenseTypeRepository.save(expenseType);
    }
}