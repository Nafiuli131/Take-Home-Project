package com.example.service;

import com.example.model.Schedule;
import com.example.repository.ScheduleRepo;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class CreateTaskService {
    ScheduleRepo scheduleRepo;

    public CreateTaskService(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }
    public Schedule createTask(Schedule schedule){

        return scheduleRepo.save(schedule);
    }
}
