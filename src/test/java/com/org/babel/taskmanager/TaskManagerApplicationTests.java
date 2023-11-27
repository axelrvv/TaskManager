package com.org.babel.taskmanager;

import com.org.babel.taskmanager.controllers.TaskController;
import com.org.babel.taskmanager.controllers.UserController;
import com.org.babel.taskmanager.models.Task;
import com.org.babel.taskmanager.models.User;
import com.org.babel.taskmanager.repositories.TaskRepository;
import com.org.babel.taskmanager.service.TaskService;
import com.org.babel.taskmanager.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class TaskManagerApplicationTests {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void TaskService_AddTask_ReturnSavedTask(){

        Task task = new Task();
        task.setTask_name("Test Task");
        task.setTask_description("This is a test");
        task.setTask_status("PENDING");

        Task addedTask = taskService.addTask(task);

        Assertions.assertNotNull(addedTask);
        Assertions.assertTrue(addedTask.getTask_id() > 0);
    }

    @Test
    public void UserService_AddUser_ReturnSavedUser(){
        User user = new User();
        user.setUser_name("testUser");

        User addedUser = userService.addUser(user);

        Assertions.assertNotNull(addedUser);
        Assertions.assertTrue(addedUser.getUser_id() > 0);
    }

}
