package com.diligent.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    List<Task> allTasks;

    TaskRepository(){
        allTasks = new ArrayList<>();
    }

    public List<Task> getAllTasks(){
        return allTasks;
    }

    public List<Task> addTask(Task task){
        allTasks.add(task);
        return allTasks;
    }

    public void markAsDispatched(UUID taskId){
        allTasks.stream().filter(t -> t.getId() == taskId).findFirst().get().setState(TaskState.DISPATCHED);
    }

}
