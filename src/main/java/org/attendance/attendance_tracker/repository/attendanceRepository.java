package org.attendance.attendance_tracker.repository;

import org.attendance.attendance_tracker.dto.attendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface attendanceRepository extends JpaRepository<attendanceRecord, Integer>{

}
