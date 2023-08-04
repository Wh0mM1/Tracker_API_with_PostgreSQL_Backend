package com.wh0mm1.TrackerService.service;

import com.wh0mm1.TrackerService.model.TaskRequest;
import com.wh0mm1.TrackerService.model.TaskResponse;

import java.util.List;

public interface TrackerService {
    long addTask(TaskRequest taskRequest);
    TaskResponse getTaskById(long taskId);

    List<TaskResponse> getAllTasks();

    String deleteTaskById(String id);

    void updateTask(long taskId, TaskRequest taskRequest);
}
