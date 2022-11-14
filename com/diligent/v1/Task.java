package com.diligent.v1;

import java.util.UUID;

public class Task {
    private UUID id;
    private String description;
    private TaskPriority priority;
    private int taskDurationInMilliseconds;

    public Task(UUID id, String description, TaskPriority priority, int taskDurationInMilliseconds){
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.taskDurationInMilliseconds = taskDurationInMilliseconds;
    }

    public UUID getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public TaskPriority getTaskPriority(){
        return priority;
    }

    public int getTaskDurationInMilliseconds(){
        return taskDurationInMilliseconds;
    }
}