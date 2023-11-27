package com.org.babel.taskmanager.controllers;

import com.org.babel.taskmanager.models.Task;
import com.org.babel.taskmanager.models.User;
import com.org.babel.taskmanager.service.TaskService;
import com.org.babel.taskmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task-manager/tasks")
public class TaskController {

    public TaskService taskService;
    public UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> list(){
        List<Task> tasks = taskService.getAllTasks();
        if (tasks != null){
            return ResponseEntity.status(HttpStatus.OK).body(tasks);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task task = taskService.getTask(id);
        if (task != null){
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        if (task != null){
            Task newTask = taskService.addTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskService.updateTask(id,task);
        if (updatedTask != null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        Task deletedTask = taskService.deleteTask(id);
        if (deletedTask != null){
            return ResponseEntity.status(HttpStatus.OK).body(deletedTask);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{task_id}/users/{user_id}")
    public ResponseEntity<String> assignUserToTask(@PathVariable Long task_id, @PathVariable Long user_id){

        User user = userService.getUser(user_id);
        Task task = taskService.getTask(task_id);

        if(user != null && task != null){
            taskService.assignUserToTask(task,user);
            return ResponseEntity.status(HttpStatus.OK).body("User assigned to task successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find either the user or the task you're looking to assign");

    }

}
