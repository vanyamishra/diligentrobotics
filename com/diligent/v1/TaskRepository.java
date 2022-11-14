package com.diligent.v1;

import java.util.ArrayList;
import java.util.List;

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

}
