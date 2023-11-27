package com.org.babel.taskmanager.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "tasks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskID;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description")
    private String taskDescription;
    @Column(name = "task_creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date taskCreationDate;
    @Column(name = "task_expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date taskExpirationDate;
    @Column(name = "task_status")
    private String taskStatus;
    @ManyToMany
    @JoinTable(
            name = "user_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long task_id) {
        this.taskID = task_id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String task_name) {
        this.taskName = task_name;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String task_description) {
        this.taskDescription = task_description;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String task_status) {
        this.taskStatus = task_status;
    }

    public Date getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(Date task_creation_date) {
        this.taskCreationDate = task_creation_date;
    }

    public Date getTaskExpirationDate() {
        return taskExpirationDate;
    }

    public void setTaskExpirationDate(Date task_expiration_date) {
        this.taskExpirationDate = task_expiration_date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
