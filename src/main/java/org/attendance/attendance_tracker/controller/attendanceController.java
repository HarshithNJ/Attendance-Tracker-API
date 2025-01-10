package org.attendance.attendance_tracker.controller;

import java.util.List;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.attendance.attendance_tracker.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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





    
    /*To Fetch Attendance Records*/
    //To Get All Attendance Records
    @GetMapping("/attendance")
    public ResponseEntity<Object> getAllAttendance(){
        return service.getAllAttendance();
    }

    //To Get Attendance Record By name
    @GetMapping("/attendance/{name}")
    public ResponseEntity<Object> getAttendanceByName(@PathVariable String name){
        return service.getAttendanceByName(name);
    }
    
    //To Get Attendance Record By presenties By Date
    @GetMapping("/attendance/date/{date}")
    public ResponseEntity<Object> getAttendanceByDate(@PathVariable String date){
        return service.getAttendanceByDate(date);
    }





    /*To Delete Attendance Records*/
    //To Delete a Attendance Record By Id
    @GetMapping("/attendance/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }
}
