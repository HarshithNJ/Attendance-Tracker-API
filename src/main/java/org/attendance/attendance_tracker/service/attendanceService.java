package org.attendance.attendance_tracker.service;

import java.util.HashMap;
import java.util.Map;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.attendance.attendance_tracker.repository.attendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class attendanceService {

    @Autowired
    attendanceRepository repository;

    public ResponseEntity<Object> saveAttendance(attendanceRecord attendance) {
        if (repository.existByRollNoAndDate(attendance.getRollNO(), attendance.getDate())) {
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data Already Exists");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{

            repository.save(attendance);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance marked for " + attendance.getName());
            map.put("Data", attendance);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
    
}
