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
@RequestMapping("task-manager/users")
public class UserController {

    private UserService userService;
    private TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> list(){

        List<User> users =  userService.getAllUsers();

        if(users != null){
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        if (user != null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user != null){
            User newUser = userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);

        if(updatedUser != null){
            System.out.println("HELLO");
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User userToDelete = userService.deleteUser(id);

        if(userToDelete != null){
            return ResponseEntity.status(HttpStatus.OK).body(userToDelete);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{user_id}/tasks/{task_id}")
    public ResponseEntity<String> assignTaskToUser(@PathVariable Long user_id, @PathVariable Long task_id){

        User user = userService.getUser(user_id);
        Task task = taskService.getTask(task_id);

        if(user != null && task != null){
            taskService.assignUserToTask(task, user);
            return ResponseEntity.status(HttpStatus.OK).body("Task assigned to user successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find either the user or the task you're looking to assign");

    }
}
