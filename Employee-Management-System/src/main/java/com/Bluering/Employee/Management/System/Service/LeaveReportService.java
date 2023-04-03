package com.Bluering.Employee.Management.System.Service;


import com.Bluering.Employee.Management.System.Model.LeaveReport;
import com.Bluering.Employee.Management.System.Repository.LeaveReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class LeaveReportService {

    private static LeaveReportRepository leaveReportRepository;
    @Autowired
    private LeaveReportRepository leaveReportRepository;

    public static Page<LeaveReport> getLeavesByEmployee(Long employeeId, LocalDate fromDate, LocalDate toDate, int page, int size) {
        return leaveReportRepository.findByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqual(employeeId, fromDate, toDate, PageRequest.of(page, size));
    }

    public static Page<LeaveReport> getLeavesByTypeAndEmployee(Long leaveTypeId, Long employeeId, LocalDate fromDate, LocalDate toDate, int page, int size) {
        return leaveReportRepository.findByLeaveTypeIdAndEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqual(leaveTypeId, employeeId, fromDate, toDate, PageRequest.of(page, size));
    }
}
