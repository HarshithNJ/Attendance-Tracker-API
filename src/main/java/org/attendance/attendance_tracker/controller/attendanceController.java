package org.attendance.attendance_tracker.controller;

import org.attendance.attendance_tracker.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class attendanceController {

    @Autowired
    attendanceService service;
    
}
