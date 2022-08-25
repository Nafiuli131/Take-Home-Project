package com.example.controller;

import com.example.dto.AssignTaskDto;
import com.example.dto.TimeRangeDto;
import com.example.dto.TimeRangeTaskDto;
import com.example.model.Player;
import com.example.model.Schedule;
import com.example.service.AssignTaskService;
import com.example.service.CreateTaskService;
import com.example.service.GetTaskListService;
import com.example.service.PlayerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    PlayerService playerService;
    @Autowired
    CreateTaskService createTaskService;
    @Autowired
    AssignTaskService assignTaskService;
    @Autowired
    GetTaskListService getTaskListService;
    @PostMapping("/createPlayer")
    public Player createPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
    @PostMapping("/createTask")
    public Schedule createTask(@RequestBody Schedule schedule){
        return createTaskService.createTask(schedule);
    }
    @PostMapping("/assignTask")
    public String assignTask(@RequestBody AssignTaskDto assignTaskDto) throws Exception {
        return assignTaskService.assignTask(assignTaskDto);
    }
    @GetMapping("/taskList/{player_id}")
    public List<String> taskList(@PathVariable int player_id){
        return assignTaskService.taskList(player_id);
    }
    @PostMapping("/getTaskByRange")
    public List<TimeRangeTaskDto> getTaskList(@RequestBody TimeRangeDto timeRangeDto){
        return getTaskListService.getTaskList(timeRangeDto);
    }

}
