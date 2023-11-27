package com.org.babel.taskmanager.service;

import com.org.babel.taskmanager.models.User;
import com.org.babel.taskmanager.repositories.TaskRepository;
import com.org.babel.taskmanager.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public User addUser(User user) {
        userRepository.saveAndFlush(user);
        return user;
    }

    public User updateUser(Long id,User user){
        User existingUser = getUser(id);

        if(existingUser.getUserId() != null){
            BeanUtils.copyProperties(user, existingUser,"user_id");
            userRepository.save(existingUser);
            return existingUser;
        }else{
            return null;
        }
    }

    public User deleteUser(Long id){
        User userToDelete = getUser(id);
        if(userToDelete != null){
            userRepository.deleteById(id);
            return userToDelete;
        }
        return null;
    }

    public User getUser(Long id){
        try{
            User user = userRepository.findById(id).get();
            return user;
        }catch (Exception e){
            return null;
        }
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();

        if(users.size() == 0){
            return null;
        }else{
            return users;
        }
    }

}
