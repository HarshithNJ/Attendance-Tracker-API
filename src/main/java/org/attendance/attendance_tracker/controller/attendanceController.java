package org.attendance.attendance_tracker.controller;

import java.util.List;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.attendance.attendance_tracker.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Tag(name = "Attendance Tracker", description = "A Controller To manage Attendance Tracking information")
public class attendanceController {

    @Autowired
    attendanceService service;

    /*To Save Attendance Record*/
    @Operation(summary = "To Save Attendance Record", description = "To Save Attendance Record")
    @ApiResponse(responseCode = "201", description = "Success")
    @ApiResponse(responseCode = "400", description = "Not Found")
    @PostMapping("/attendance")
    public ResponseEntity<Object> saveAttendance(@RequestBody attendanceRecord attendance){
        return service.saveAttendance(attendance);
    }

    //To save Multiple Attendance Record
    @Operation(summary = "To Save Multiple Attendance Records", description = "To Save Multiple Attendance Records")
    @ApiResponse(responseCode = "201", description = "Success")
    @ApiResponse(responseCode = "400", description = "Not Found")
    @PostMapping("/attendance/multiple")
    public ResponseEntity<Object> saveMultiple(@RequestBody List<attendanceRecord> multiple){
        return service.saveMultiple(multiple);
    }





    
    /*To Fetch Attendance Records*/
    @Operation(summary = "To Get All Attendance Records", description = "To Get All Attendance Records")
    @ApiResponse(responseCode = "302", description = "Data Found")
    @ApiResponse(responseCode = "404", description = "Data Not Found")
    @GetMapping("/attendance")
    public ResponseEntity<Object> getAllAttendance(){
        return service.getAllAttendance();
    }

    
    @Operation(summary = "To Get All Attendance Records By Name", description = "To Get All Attendance Records By Name")
    @ApiResponse(responseCode = "302", description = "Data Found")
    @ApiResponse(responseCode = "404", description = "Data Not Found")
    @GetMapping("/attendance/{name}")
    public ResponseEntity<Object> getAttendanceByName(@PathVariable String name){
        return service.getAttendanceByName(name);
    }
    
    
    @Operation(summary = "To Get All Attendance Records By Date", description = "To Get All Attendance Records By Date")
    @ApiResponse(responseCode = "302", description = "Data Found")
    @ApiResponse(responseCode = "404", description = "Data Not Found")
    @GetMapping("/attendance/date/{date}")
    public ResponseEntity<Object> getAttendanceByDate(@PathVariable String date){
        return service.getAttendanceByDate(date);
    }





    /*To Delete Attendance Records*/
    @Operation(summary = "To Delete Attendance Record By Id", description = "To Delete Attendance Record By Id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "204", description = "Failure")
    @GetMapping("/attendance/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }





    /* To Update Attendance Record */
    @Operation(summary = "To Update Attendance Record Using Patch", description = "To Update Attendance Record Using Patch")
    @ApiResponse(responseCode = "202", description = "Updated Success")
    @ApiResponse(responseCode = "406", description = "Update Failure")
    @PatchMapping("/attendance/{id}")
    public ResponseEntity<Object> updateAttendance(@PathVariable int id, @RequestBody attendanceRecord attendance){
        return service.updateAttendance(id, attendance);
    }
}
