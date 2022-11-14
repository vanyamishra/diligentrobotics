package com.diligent.v1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createNewTaskRequest(final String description, final TaskPriority taskPriority, int taskDurationInMilliseconds){
        Task taskToAdd = new Task(UUID.randomUUID(), description, taskPriority, taskDurationInMilliseconds);
        taskRepository.addTask(taskToAdd);
    }

    public void dispatchRequestedTasks(final List<Task> requestedTasks){
        if(requestedTasks.stream().anyMatch(t -> t.getTaskPriority().equals(TaskPriority.HIGH))){
            List<Task> highPriorityTasks = requestedTasks.stream().filter(t -> t.getTaskPriority() == TaskPriority.HIGH).collect(Collectors.toList());
            sortTasksBasedOnDuration(highPriorityTasks);
            dispatchTasks(highPriorityTasks);
        }
        if(requestedTasks.stream().anyMatch(t -> t.getTaskPriority().equals(TaskPriority.MEDIUM))){
            List<Task> mediumPriorityTasks = requestedTasks.stream().filter(t -> t.getTaskPriority() == TaskPriority.MEDIUM).collect(Collectors.toList());
            sortTasksBasedOnDuration(mediumPriorityTasks);
            dispatchTasks(mediumPriorityTasks);
        }
        if(requestedTasks.stream().anyMatch(t -> t.getTaskPriority().equals(TaskPriority.LOW))){
            List<Task> lowPriorityTasks = requestedTasks.stream().filter(t -> t.getTaskPriority() == TaskPriority.LOW).collect(Collectors.toList());
            sortTasksBasedOnDuration(lowPriorityTasks);
            dispatchTasks(lowPriorityTasks);
        }
        
    }

    private void dispatchTasks(final List<Task> tasks){
        for(final Task eachTask : tasks){
            System.out.print("Dispatching task "+eachTask.getId()+" - ");
            System.out.print(eachTask.getDescription()+", ");
            System.out.print("with priority "+eachTask.getTaskPriority()+", ");
            System.out.print("with duration "+eachTask.getDurationInMilliseconds()+", ");
            System.out.print("with state "+eachTask.getState());
            System.out.println();
            taskRepository.markAsDispatched(eachTask.getId());
        }
    }
    
    private List<Task> sortTasksBasedOnDuration(final List<Task> currentTasks){
        Collections.sort(currentTasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2){
                return task1.getDurationInMilliseconds() - task2.getDurationInMilliseconds();
            }
        });
        return currentTasks;
    }

    public void viewAllTasks(){
        final List<Task> allTasks = taskRepository.getAllTasks();
        for(final Task eachTask : allTasks){
            System.out.println("Id: "+eachTask.getId());
            System.out.println("Description: "+eachTask.getDescription());
            System.out.println("Priority: "+eachTask.getTaskPriority());
            System.out.println("Duration: "+eachTask.getDurationInMilliseconds());
            System.out.println("State: "+eachTask.getState());
        }
    }
}
