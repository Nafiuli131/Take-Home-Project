package com.example.repository;

import com.example.model.AssignTask;
import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignTaskRepo extends JpaRepository<AssignTask,Integer> {


}
