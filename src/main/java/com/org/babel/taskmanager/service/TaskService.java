package com.org.babel.taskmanager.service;

import com.org.babel.taskmanager.models.Task;
import com.org.babel.taskmanager.models.User;
import com.org.babel.taskmanager.repositories.TaskRepository;
import com.org.babel.taskmanager.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    public Task addTask(Task task) {
        taskRepository.saveAndFlush(task);
        return task;
    }

    public Task updateTask(Long id,Task task){
        Task existingTask = getTask(id);

        if(existingTask.getTask_id() != null){
            BeanUtils.copyProperties(task, existingTask,"task_id");
            taskRepository.save(existingTask);
            return existingTask;
        }else{
            return null;
        }
    }

    public Task deleteTask(Long id){
        Task taskToDelete = getTask(id);
        if(taskToDelete != null){
            taskRepository.deleteById(id);
            return taskToDelete;
        }
        return null;
    }

    public Task getTask(Long id){
        try{
            Task task = taskRepository.findById(id).get();
            return task;
        }catch(Exception e){
            return null;
        }
    }

    public List<Task> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        if(tasks.size() == 0){
            return null;
        }else{
            return tasks;
        }

    }

    public void assignUserToTask(Task task, User user) {

        task.getUsers().add(user);
        user.getTasks().add(task);
        userRepository.save(user);
        taskRepository.save(task);

    }
}
