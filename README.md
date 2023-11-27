# TaskManager

Spring Boot App to manage tasks

## Features

| Feature                           | Status |
|-----------------------------------|--------|
| **Spring Boot Development**       |   ✅    |
| **Uses Amazon RDS**               |    ✅    |
| **Uses Hibernate to map objects** |    ✅    |
| **Task & User CRUD Controller**   |    ✅    |
| **Uses Spring Security**          |   ✅    |
| **Uses Maven**                    |    ✅    |
| **Simple Unit test implemented**  |    ✅    |

## Usage

1. Clone the project
2. Upload it in your preferred text editor or IDE (I used IntelliJ IDEA)
3. Request the cloud database password to my email (axelrvv@gmail.com)
4. Run the project
5. Make request either using PostMan, SoapUI or your local browser

## Essential Functions

| Url                                                | Functionality           | Method |
|----------------------------------------------------|-------------------------|--------|
| http://localhost:8080/task-manager/                | Home Controller         | GET    |
| http://localhost:8080/task-manager/tasks/          | Gets all existing tasks | GET    |
| http://localhost:8080/task-manager/users/          | Gets all existing users | GET    |
| http://localhost:8080/task-manager/tasks/          | Creates a new task      | POST   |
| http://localhost:8080/task-manager/users/          | Creates a new user      | POST   |
| http://localhost:8080/task-manager/tasks/{task_id} | Updates a task          | PUT    |
| http://localhost:8080/task-manager/users/{user_id} | Updates a user          | PUT    |
| http://localhost:8080/task-manager/tasks/{task_id} | Deletes a task          | DELETE |
| http://localhost:8080/task-manager/users/{user_id} | Deletes a user          | DELETE |
