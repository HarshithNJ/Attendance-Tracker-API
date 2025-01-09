package org.attendance.attendance_tracker.controller;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.attendance.attendance_tracker.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class attendanceController {

    @Autowired
    attendanceService service;

    /*To Save Attendance Record*/
    //To save Single Attendance Record
    @GetMapping("/attendance")
    public ResponseEntity<Object> saveAttendance(@RequestBody attendanceRecord attendance){
        return service.saveAttendance(attendance);
    }
    
    
}
