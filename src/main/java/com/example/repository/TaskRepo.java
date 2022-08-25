package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    @Query(value = "SELECT DISTINCT task_id  FROM assign_task where player_id=?1",nativeQuery = true)
    public List<Integer> getTaskList(int player_id);



}
