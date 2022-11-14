package com.diligent.v1;

import java.util.UUID;

public class Task {
    private UUID id;
    private String description;
    private TaskPriority priority;
    private int durationInMilliseconds;
    private TaskState state;

    public Task(UUID id, String description, TaskPriority priority, int durationInMilliseconds){
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.durationInMilliseconds = durationInMilliseconds;
        this.state = TaskState.ACTIVE;
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

    public int getDurationInMilliseconds(){
        return durationInMilliseconds;
    }

    public TaskState getState(){
        return state;
    }

    public void setState(final TaskState taskState){
        this.state = taskState;
    }
}