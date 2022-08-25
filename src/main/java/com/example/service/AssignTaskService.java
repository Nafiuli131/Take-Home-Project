package com.example.service;

import com.example.dto.AssignTaskDto;
import com.example.model.AssignTask;
import com.example.model.Task;
import com.example.repository.AssignTaskRepo;
import com.example.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AssignTaskService {
    @Autowired
    AssignTaskRepo assignTaskRepo;
    @Autowired
    TaskRepo taskRepo;
    public String assignTask(AssignTaskDto assignTaskDto) throws Exception{
        AtomicReference<String> message = new AtomicReference<>("not found");
        List<Integer> playerId = assignTaskDto.getPlayer_id();
        int task_id = assignTaskDto.getTask_id();

        Optional<Task> taskFinder = taskRepo.findById(task_id);

        if(task_id==taskFinder.get().getT_id()){

                    playerId.forEach(player->{

            AssignTask assignTask = new AssignTask();
            assignTask.setPlayer_id(player);
            assignTask.setTask_id(assignTaskDto.getTask_id());
            assignTaskRepo.save(assignTask);
                        System.out.println("task assign successfully");
                        message.set("task assign successfully");
        });
        } else {
            throw new Exception();
        }

        return message.get();
    }
    public List<String> taskList(int player_id){
             List<Integer> taskListId = taskRepo.getTaskList(player_id);
             List<String> taskName =new ArrayList<>();
             taskListId.forEach(taskDetails->{

                 Optional<Task> taskFinder = taskRepo.findById(taskDetails);

                 System.out.println(taskFinder.get().getT_name());
                 taskName.add(String.valueOf(taskFinder.get().getT_name()));
             });

        return taskName;
    }
}
