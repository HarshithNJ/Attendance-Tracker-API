package org.attendance.attendance_tracker.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class attendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rollNO;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private String status;
    
}
