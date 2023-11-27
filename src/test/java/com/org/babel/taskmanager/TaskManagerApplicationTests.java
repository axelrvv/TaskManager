package com.org.babel.taskmanager;

import com.org.babel.taskmanager.models.Task;
import com.org.babel.taskmanager.models.User;
import com.org.babel.taskmanager.repositories.TaskRepository;
import com.org.babel.taskmanager.repositories.UserRepository;
import com.org.babel.taskmanager.service.TaskService;
import com.org.babel.taskmanager.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;


@SpringBootTest
class TaskManagerApplicationTests {

    @Mock
    UserRepository userRepository;
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    UserService userService;
    @InjectMocks
    TaskService taskService;

    @Test
    void contextLoads() {
    }

    @Test
    public void TaskService_AddTask_ReturnSavedTask(){

        Task task = new Task();
        task.setTaskName("Test Task");
        task.setTaskDescription("This is a test");
        task.setTaskStatus("PENDING");

        Task addedTask = taskService.addTask(task);

        Assertions.assertNotNull(addedTask);
        Assertions.assertTrue(addedTask.getTaskName().equals("Test Task"));
    }

    @Test
    public void UserService_AddUser_ReturnSavedUser(){
        User user = new User();
        user.setUserName("testUser");

        User addedUser = userService.addUser(user);

        Assertions.assertNotNull(addedUser);
        Assertions.assertTrue(addedUser.getUserName().equals("testUser"));
    }
}
