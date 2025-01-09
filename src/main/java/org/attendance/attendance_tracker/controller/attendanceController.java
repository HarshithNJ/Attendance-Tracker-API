package org.attendance.attendance_tracker.controller;

import java.util.List;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.attendance.attendance_tracker.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class attendanceController {

    @Autowired
    attendanceService service;

    /*To Save Attendance Record*/
    //To save Single Attendance Record
    @PostMapping("/attendance")
    public ResponseEntity<Object> saveAttendance(@RequestBody attendanceRecord attendance){
        return service.saveAttendance(attendance);
    }

    //To save Multiple Attendance Record
    @PostMapping("/attendance/multiple")
    public ResponseEntity<Object> saveMultiple(@RequestBody List<attendanceRecord> multiple){
        return service.saveMultiple(multiple);
    }
    
    
}
