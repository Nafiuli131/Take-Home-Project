package com.example.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeRangeTaskDto {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalTime start_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalTime end_time;
    private String task_name;
    private List<String> player_name;
}
