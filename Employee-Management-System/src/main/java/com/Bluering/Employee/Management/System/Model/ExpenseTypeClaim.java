package com.Bluering.Employee.Management.System.Model;


import java.math.BigDecimal;

public class ExpenseTypeClaim {
    private Employee employee;
    private ExpenseType expenseType;
    private BigDecimal totalClaims;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public BigDecimal getTotalClaims() {
        return totalClaims;
    }

    public void setTotalClaims(BigDecimal totalClaims) {
        this.totalClaims = totalClaims;
    }
}
