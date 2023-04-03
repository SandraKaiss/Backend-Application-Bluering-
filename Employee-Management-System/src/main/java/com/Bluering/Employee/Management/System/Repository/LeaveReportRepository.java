package com.Bluering.Employee.Management.System.Repository;


import com.Bluering.Employee.Management.System.Model.LeaveReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LeaveReportRepository extends JpaRepository<LeaveReport, Long> {
    Page<LeaveReport> findByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqual(Long employeeId, LocalDate fromDate, LocalDate toDate, Pageable pageable);
    Page<LeaveReport> findByLeaveTypeIdAndEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqual(Long leaveTypeId, Long employeeId, LocalDate fromDate, LocalDate toDate, Pageable pageable);
}
