package com.example.repository;

import com.example.model.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
    @Query (value="SELECT * FROM schedule s WHERE s.start_time  BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<Schedule> schduleTask(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);


}
