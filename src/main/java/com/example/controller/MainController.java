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
    //api for create player
    @PostMapping("/createPlayer")
    public Player createPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
    //api for create task with schedule id
    @PostMapping("/createTask")
    public Schedule createTask(@RequestBody Schedule schedule){
        return createTaskService.createTask(schedule);
    }
    //api for create the assign task api. multiplayer players can enroll one task
    @PostMapping("/assignTask")
    public String assignTask(@RequestBody AssignTaskDto assignTaskDto) throws Exception {
        return assignTaskService.assignTask(assignTaskDto);
    }
    //api for get the task list of a single player
    @GetMapping("/taskList/{player_id}")
    public List<String> taskList(@PathVariable int player_id){
        return assignTaskService.taskList(player_id);
    }
    //api for get all the task with the given time range
    @PostMapping("/getTaskByRange")
    public List<TimeRangeTaskDto> getTaskList(@RequestBody TimeRangeDto timeRangeDto){
        return getTaskListService.getTaskList(timeRangeDto);
    }

}
