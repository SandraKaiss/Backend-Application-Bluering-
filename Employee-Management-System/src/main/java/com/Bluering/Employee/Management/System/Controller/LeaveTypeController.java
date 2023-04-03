package com.Bluering.Employee.Management.System.Controller;


import com.Bluering.Employee.Management.System.Model.LeaveType;
import com.Bluering.Employee.Management.System.Service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leavetypes")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping("")
    public ResponseEntity<Page<LeaveType>> getAllLeaveTypes(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        PageRequest paging = PageRequest.of(page, size);

        Page<LeaveType> leaveTypes = leaveTypeService.getAllLeaveTypes(paging);

        return new ResponseEntity<>(leaveTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public LeaveType getLeaveTypeById(@PathVariable(value = "id") Long id) {
        return leaveTypeService.getLeaveTypeById(id);
    }

    @PostMapping("")
    public LeaveType createLeaveType(@RequestBody LeaveType leaveType) {
        return leaveTypeService.createLeaveType(leaveType);
    }

    @PutMapping("/{id}")
    public LeaveType updateLeaveType(@PathVariable(value = "id") Long id, @RequestBody LeaveType leaveTypeDetails) {
        return leaveTypeService.updateLeaveType(id, leaveTypeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLeaveType(@PathVariable(value = "id") Long id) {
        leaveTypeService.deleteLeaveType(id);
        return ResponseEntity.ok().build();
    }
}
