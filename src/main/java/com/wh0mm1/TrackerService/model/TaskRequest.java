package com.wh0mm1.TrackerService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private Date dueDate;
}
