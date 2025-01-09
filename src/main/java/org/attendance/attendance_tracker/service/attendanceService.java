package org.attendance.attendance_tracker.service;

import java.util.HashMap;
import java.util.List;
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
        if (repository.existsByNameAndDate(attendance.getName(), attendance.getDate())) {
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Attendance Already Marked");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{

            repository.save(attendance);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance marked for " + attendance.getName());
            map.put("Data", attendance);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> saveMultiple(List<attendanceRecord> multiple) {
        for(attendanceRecord attendance : multiple){
            if (repository.existsByNameAndDate(attendance.getName(), attendance.getDate())) {
            
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Attendance Already Marked");
    
                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
            }
        }
        repository.saveAll(multiple);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance marked Successfully");
            map.put("Data", multiple);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }
    
}
