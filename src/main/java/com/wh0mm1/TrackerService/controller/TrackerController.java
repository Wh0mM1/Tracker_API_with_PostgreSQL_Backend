package com.wh0mm1.TrackerService.controller;

import com.wh0mm1.TrackerService.model.TaskRequest;
import com.wh0mm1.TrackerService.model.TaskResponse;
import com.wh0mm1.TrackerService.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @PostMapping
    public ResponseEntity<Long> addTask(@RequestBody TaskRequest taskRequest)
    {
        long taskId=trackerService.addTask(taskRequest);
        return new ResponseEntity<>(taskId, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskResponse> getAllTasks()
    {
        return trackerService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable("id") long taskId)
    {
        TaskResponse taskResponse=trackerService.getTaskById(taskId);
        return new ResponseEntity<>(taskResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable String id)
    {
        return trackerService.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(
            @PathVariable("id") long taskId,
            @RequestBody TaskRequest taskRequest
    ){
        trackerService.updateTask(taskId,taskRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
