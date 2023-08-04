package com.wh0mm1.TrackerService.service;

import com.wh0mm1.TrackerService.entity.Task;
import com.wh0mm1.TrackerService.exception.TaskServiceCustomException;
import com.wh0mm1.TrackerService.model.TaskRequest;
import com.wh0mm1.TrackerService.model.TaskResponse;
import com.wh0mm1.TrackerService.repository.TaskRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TrackerServiceImp implements TrackerService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public long addTask(TaskRequest taskRequest) {
        log.info("Adding Task..");
        Task task
                =Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .dueDate(taskRequest.getDueDate())
                .build();

        taskRepository.save(task);
        log.info("Task Added");
        return task.getTaskId();
    }

    @Override
    public TaskResponse getTaskById(long taskId) {
        log.info("Get task for taskId: {}",taskId);
        Task task=taskRepository.findById(taskId).orElseThrow(()->new TaskServiceCustomException("Task with given id not found","TASK_NOT_FOUND"));
        TaskResponse taskResponse=new TaskResponse();
        BeanUtils.copyProperties(task,taskResponse);
        return taskResponse;
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> taskList=taskRepository.findAll();
        List<TaskResponse> taskResponses=taskList.stream().map(task -> {
            TaskResponse taskResponse=new TaskResponse();
            BeanUtils.copyProperties(task,taskResponse);
            return taskResponse;
        }).collect(Collectors.toList());
        return taskResponses;
    }

    @Override
    public String deleteTaskById(String id) {
        log.info("Deleting Task with Id: {}",id);
        taskRepository.findById(Long.valueOf(id)).orElseThrow(()->new TaskServiceCustomException("Task with given id not found","TASK_NOT_FOUND"));
        taskRepository.deleteById(Long.valueOf(id));
        log.info("Task with given id deleted! Id:{}",id);
        return "Task deleted with the id: "+id;
    }

    @Override
    public void updateTask(long taskId, TaskRequest taskRequest) {
        log.info("Updating task with Id: {}",taskId);
        Task task=taskRepository.findById(taskId)
                .orElseThrow(()->new TaskServiceCustomException("Task with given Id not found","TASK_NOT_FOUND"));
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setTitle(taskRequest.getTitle());
        taskRepository.save(task);
        log.info("Task Updated");
    }
}
