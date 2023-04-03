package com.Bluering.Employee.Management.System.Repository;

import com.Bluering.Employee.Management.System.Model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.Bluering.Employee.Management.System.Model.Leave;
//import com.Bluering.Employee.Management.System.Model.LeaveType;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
//
//    @Query("SELECT l FROM Leave l WHERE l.leaveType.name = :leaveTypeName AND l.employee.id = :employeeId AND l.leaveDate BETWEEN :fromDate AND :toDate")
//    List<Leave> findLeavesByLeaveTypeNameAndEmployeeIdAndLeaveDateBetween(String leaveTypeName, Long employeeId, LocalDate fromDate, LocalDate toDate, SpringDataWebProperties.Pageable pageable);
//
//}
@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}
