package org.attendance.attendance_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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






    
    public ResponseEntity<Object> getAllAttendance() {
        List<attendanceRecord> records = repository.findAll();
        if(records.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Records Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance Records Found");
            map.put("Data", records);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getAttendanceByName(String name) {
        List<attendanceRecord> li = repository.findByName(name);
        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Records Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance Records Found");
            map.put("Data", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getAttendanceByDate(String date) {
        List<attendanceRecord> li = repository.findByDate(date);

        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Records Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance Records Found");
            map.put("Data", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> deleteById(int id) {
        Optional<attendanceRecord> op = repository.findById(id);
        if(op.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Attendance Record Deleted with the roll No :" + op.get().getRollNO());
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Attendance Record Not Found");

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }
    }
    
}
