package com.example.foodprojectmain.dao.repository.user;

import com.example.foodprojectmain.dao.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
