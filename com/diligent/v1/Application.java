package com.diligent.v1;

import java.util.UUID;

public class Application {
    public static void main(String args[]){
        
        // Task task1 = new Task(UUID.randomUUID(), "Task 1", TaskPriority.HIGH, 1000);
        // Task task2 = new Task(UUID.randomUUID(), "Task 2", TaskPriority.HIGH, 500);
        // Task task3 = new Task(UUID.randomUUID(), "Task 3", TaskPriority.HIGH, 200);
        // Task task4 = new Task(UUID.randomUUID(), "Task 4", TaskPriority.MEDIUM, 1000);
        // Task task5 = new Task(UUID.randomUUID(), "Task 5", TaskPriority.MEDIUM, 500);
        // Task task6 = new Task(UUID.randomUUID(), "Task 6", TaskPriority.MEDIUM, 200);
        // Task task7 = new Task(UUID.randomUUID(), "Task 7", TaskPriority.LOW, 1000);
        // Task task8 = new Task(UUID.randomUUID(), "Task 8", TaskPriority.LOW, 500);
        // Task task9 = new Task(UUID.randomUUID(), "Task 9", TaskPriority.LOW, 200);
        
        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskDispatchService = new TaskService(taskRepository);

        taskDispatchService.createNewTaskRequest("Task 1", TaskPriority.HIGH, 1000);
        taskDispatchService.createNewTaskRequest("Task 2", TaskPriority.HIGH, 750);
        taskDispatchService.createNewTaskRequest("Task 3", TaskPriority.HIGH, 500);
        taskDispatchService.createNewTaskRequest("Task 4", TaskPriority.MEDIUM, 1000);
        taskDispatchService.createNewTaskRequest("Task 5", TaskPriority.MEDIUM, 750);
        taskDispatchService.createNewTaskRequest("Task 6", TaskPriority.MEDIUM, 500);
        taskDispatchService.createNewTaskRequest("Task 7", TaskPriority.LOW, 1000);
        taskDispatchService.createNewTaskRequest("Task 8", TaskPriority.LOW, 750);
        taskDispatchService.createNewTaskRequest("Task 9", TaskPriority.LOW, 500);

        taskDispatchService.viewAllTasks();
        taskDispatchService.dispatchRequestedTasks(taskRepository.getAllTasks());
    }
}
