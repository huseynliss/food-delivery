package com.example.foodprojectmain.dao.repository.user;

import com.example.foodprojectmain.dao.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}