package org.attendance.attendance_tracker.service;

import org.attendance.attendance_tracker.repository.attendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class attendanceService {

    @Autowired
    attendanceRepository repository;
    
}
