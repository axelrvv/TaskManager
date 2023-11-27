package com.org.babel.taskmanager.repositories;

import com.org.babel.taskmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
