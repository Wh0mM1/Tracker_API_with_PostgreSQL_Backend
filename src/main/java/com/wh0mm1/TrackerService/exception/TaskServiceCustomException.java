package com.wh0mm1.TrackerService.exception;

import lombok.Data;

@Data
public class TaskServiceCustomException extends RuntimeException{
    private String errorCode;

    public TaskServiceCustomException(String message,String errorCode)
    {
        super(message);
        this.errorCode=errorCode;
    }
}
