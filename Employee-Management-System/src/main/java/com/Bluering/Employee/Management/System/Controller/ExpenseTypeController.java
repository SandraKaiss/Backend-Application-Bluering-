package com.Bluering.Employee.Management.System.Controller;


import com.Bluering.Employee.Management.System.Model.ExpenseType;
import com.Bluering.Employee.Management.System.Service.ExpenseTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.Bluering.Employee.Management.System.Model.ExpenseType;
//import com.Bluering.Employee.Management.System.Service.ExpenseTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/expenseTypes")
//public class ExpenseTypeController {
//
//    @Autowired
//    private ExpenseTypeService expenseTypeService;
//
//    @GetMapping("")
//    public ResponseEntity<Page<ExpenseType>> getAllExpenseTypes(@RequestParam(defaultValue = "0") int page,
//                                                                @RequestParam(defaultValue = "10") int size) {
//        PageRequest paging = PageRequest.of(page, size);
//
//        Page<ExpenseType> expenseTypes = (Page<ExpenseType>) expenseTypeService.getAllExpenseTypes(paging);
//
//        return new ResponseEntity<>(expenseTypes, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ExpenseType getExpenseTypeById(@PathVariable(value = "id") Long id) {
//        return expenseTypeService.getExpenseTypeById(id);
//    }
//
//    @PostMapping("")
//    public ExpenseType createExpenseType(@RequestBody ExpenseType expenseType) {
//        return expenseTypeService.createExpenseType(expenseType);
//    }
//
//    @PutMapping("/{id}")
//    public ExpenseType updateExpenseType(@PathVariable(value = "id") Long id, @RequestBody ExpenseType expenseTypeDetails) {
//        return expenseTypeService.updateExpenseType(id, expenseTypeDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteExpenseType(@PathVariable(value = "id") Long id) {
//        expenseTypeService.deleteExpenseType(id);
//        return ResponseEntity.ok().build();
//    }
//}
@RestController
@RequestMapping("/expense-types")
public class ExpenseTypeController {
    private final ExpenseTypeService expenseTypeService;

    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @PostMapping
    public ExpenseType createExpenseType(@RequestBody ExpenseType expenseType) {
        return expenseTypeService.createExpenseType(expenseType);
    }
}