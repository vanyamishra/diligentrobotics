package com.diligent.v1;

public class Application {
    public static void main(String args[]){
        
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

        taskDispatchService.viewAllTasks();
    }
}
