package com.wh0mm1.TrackerService.service;

import com.wh0mm1.TrackerService.entity.Task;
import com.wh0mm1.TrackerService.model.TaskResponse;
import com.wh0mm1.TrackerService.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TrackerServiceImpTest {


    @Mock
    private TaskRepository taskRepository;


    @InjectMocks
    TrackerService trackerService=new TrackerServiceImp();

    @DisplayName("Get Task - Success Scenario")
    @Test
    void test_When_Task_Is_Present_Success()
    {
        Task task=getMockOrder();
        when(taskRepository.findById(anyLong()))
                .thenReturn(Optional.of(task));
        TaskResponse taskResponse= trackerService.getTaskById(1);

        verify(taskRepository,times(1)).findById(anyLong());

        assertNotNull(taskResponse);
        assertEquals(task.getTaskId(),taskResponse.getTaskId());
    }

    private Task getMockOrder() {
        return Task.builder()
                .taskId(1)
                .title("Title")
                .description("Description")
                .dueDate(new Date())
                .build();
    }
}
