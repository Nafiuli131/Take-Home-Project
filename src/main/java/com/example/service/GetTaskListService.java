package com.example.service;

import com.example.dto.AssignTaskDto;
import com.example.dto.TimeRangeDto;
import com.example.dto.TimeRangeTaskDto;
import com.example.model.AssignTask;
import com.example.model.Player;
import com.example.model.Schedule;
import com.example.model.Task;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GetTaskListService {
    @Autowired
    AssignTaskRepo assignTaskRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    PlayerRepo playerRepo;

     TimeRangeTaskDto timeRangeTaskDto;
    public List<TimeRangeTaskDto> getTaskList(TimeRangeDto timeRangeDto){
        List<TimeRangeTaskDto> timeRangeTaskDtoLists = null;
        List<Schedule> schedules = scheduleRepo.schduleTask(timeRangeDto.getStart_time(),timeRangeDto.getEnd_time());


        schedules.forEach(schedule -> {
            int scheduleId = schedule.getS_id();
            timeRangeDto.setStart_time(schedule.getStart_time());
            timeRangeDto.setEnd_time(schedule.getEnd_time());
            Optional<Task> getTask = taskRepo.findById(scheduleId);
             String TaskName = getTask.get().getT_name();
            timeRangeTaskDto.setTask_name(TaskName);

            Optional<AssignTask> assignTasks = assignTaskRepo.findById(getTask.get().getT_id());
            Optional<Player> players = playerRepo.findById(assignTasks.get().getPlayer_id());
            String playerName = players.get().getP_name();
            timeRangeTaskDto.setPlayer_name(Collections.singletonList(playerName));
            timeRangeTaskDtoLists.add(timeRangeTaskDto);
        });

        return timeRangeTaskDtoLists;
    }
}
