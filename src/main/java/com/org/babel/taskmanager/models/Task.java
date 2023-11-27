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
    private Long task_id;
    private String task_name;
    private String task_description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date task_creation_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date task_expiration_date;
    private String task_status;
    @ManyToMany
    @JoinTable(
            name = "user_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public Date getTask_creation_date() {
        return task_creation_date;
    }

    public void setTask_creation_date(Date task_creation_date) {
        this.task_creation_date = task_creation_date;
    }

    public Date getTask_expiration_date() {
        return task_expiration_date;
    }

    public void setTask_expiration_date(Date task_expiration_date) {
        this.task_expiration_date = task_expiration_date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
