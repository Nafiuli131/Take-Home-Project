package com.example.controller;

import com.example.model.Player;
import com.example.model.Task;
import com.example.service.CreateTaskService;
import com.example.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MainControllerTest {
    @InjectMocks
    MainController mainController;
    @Mock
    PlayerService playerService;
    @Mock
    CreateTaskService createTaskService;
    @Test
    void createPlayer() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Player player = new Player(1, "Nafiul");
        assertThat(player.getP_name().equals("Aminul")).isEqualTo(false);
    }


    @Test
    void createTask() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Task task = new Task(1,"batting");
        assertThat(task.getT_name().equals("run")).isEqualTo(true);
//        assertThat(player.getP_name().equals("Aminul")).isEqualTo(false);
    }

    @Test
    void assignTask() {
    }

    @Test
    void taskList() {
    }

    @Test
    void getTaskList() {
    }
}