package com.Bluering.Employee.Management.System.Service;

import com.Bluering.Employee.Management.System.Model.LeaveReport;
import com.Bluering.Employee.Management.System.Model.LeaveType;
import com.Bluering.Employee.Management.System.Repository.LeaveTypeRepository;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public LeaveType createLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    public LeaveType updateLeaveType(Long id, LeaveType leaveType) {
        Optional optionalLeaveType = leaveTypeRepository.findById(leaveType.getId());

        if (optionalLeaveType.isPresent()) {
            LeaveType existingLeaveType = (LeaveType) optionalLeaveType.get();
            existingLeaveType.setName(leaveType.getName());
            existingLeaveType.setDescription(leaveType.getDescription());
            existingLeaveType.setDays(leaveType.getDays());
            return leaveTypeRepository.save(existingLeaveType);
        }

        throw new ChangeSetPersister.NotFoundException("Leave type not found with id " + leaveType.getId());
    }

    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    public LeaveType getLeaveTypeById(Long id) {
        Optional optionalLeaveType = leaveTypeRepository.findById(id);

        if (optionalLeaveType.isPresent()) {
            return (LeaveType) optionalLeaveType.get();
        }

        throw new ChangeSetPersister.NotFoundException("Leave type not found with id " + id);
    }

    public void deleteLeaveTypeById(Long id) {
        Optional<LeaveType> optionalLeaveType = leaveTypeRepository.findById(id);

        if (optionalLeaveType.isPresent()) {
            leaveTypeRepository.delete(optionalLeaveType.get());
        } else {
            throw new ChangeSetPersister.NotFoundException("Leave type not found with id " + id);
        }
    }

    public List<LeaveReport> getLeavesByLeaveTypeAndEmployeeId(String leaveTypeName, Long employeeId, LocalDate fromDate, LocalDate toDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return leaveTypeRepository.findLeavesByLeaveTypeNameAndEmployeeIdAndLeaveDateBetween(leaveTypeName, employeeId, fromDate, toDate, pageable);
    }

    public void deleteLeaveType(Long id) {
    }
}
