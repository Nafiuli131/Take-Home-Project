package com.example.controller;

import com.example.dto.TimeRangeTaskDto;
import com.example.model.AssignTask;
import com.example.model.Player;
import com.example.model.Task;
import com.example.service.AssignTaskService;
import com.example.service.CreateTaskService;
import com.example.service.GetTaskListService;
import com.example.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.RouteMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class MainControllerTest {
    @InjectMocks
    MainController mainController;
    @Mock
    PlayerService playerService;
    @Mock
    CreateTaskService createTaskService;
    @Mock
    AssignTaskService assignTaskService;
    @Mock
    GetTaskListService getTaskListService;
    //output should be fine
    @Test
    void createPlayer() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Player player = new Player(1, "Nafiul");
        assertThat(player.getP_name().equals("Aminul")).isEqualTo(false);
    }

    //output should found error
    @Test
    void createTask() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Task task = new Task(1,"batting");
        assertThat(task.getT_name().equals("run")).isEqualTo(true);

    }
    //output should be fine
    @Test
    void assignTask() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        AssignTask assignTask = new AssignTask(1,2,2);
        assertThat(assignTask.getTask_id()).isEven();
    }
    //output should be fine
    @Test
    void taskList() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        String getApiUrl =  "http://localhost:8080/taskList";
        String url = "http://localhost:8080/taskList";
        assertThat(getApiUrl.equals(url));
    }


}