package com.Bluering.Employee.Management.System.Controller;


import com.Bluering.Employee.Management.System.Model.LeaveReport;
import com.Bluering.Employee.Management.System.Repository.LeaveTypeRepository;
import com.Bluering.Employee.Management.System.Service.LeaveReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @PostMapping("/report")
    public void submitLeaveReport(@RequestParam Long employeeId, @RequestParam Long leaveTypeId, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        // logic to submit leave report
    }

    @GetMapping("/{employeeId}")
    public Page<LeaveReport> getLeavesByEmployee(@PathVariable Long employeeId, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // logic to get leaves by employee
        return LeaveReportService.getLeavesByEmployee(employeeId, fromDate, toDate, page, size);
    }

    @GetMapping("/{leaveTypeId}/employees")
    public Page<LeaveReport> getLeavesByTypeAndEmployee(@PathVariable Long leaveTypeId, @RequestParam Long employeeId, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // logic to get leaves by type and employee
        return LeaveReportService.getLeavesByTypeAndEmployee(leaveTypeId, employeeId, fromDate, toDate, page, size);
    }
}
