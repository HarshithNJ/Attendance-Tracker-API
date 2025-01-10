package org.attendance.attendance_tracker.repository;

import java.util.List;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface attendanceRepository extends JpaRepository<attendanceRecord, Integer>{

    boolean existsByNameAndDate(String name, String date);

    List<attendanceRecord> findByName(String name);

    List<attendanceRecord> findByDate(String date);

}
