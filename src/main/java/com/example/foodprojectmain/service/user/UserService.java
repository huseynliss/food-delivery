package com.example.foodprojectmain.service.user;

import com.example.foodprojectmain.dao.entity.user.Role;
import com.example.foodprojectmain.dao.entity.user.User;
import com.example.foodprojectmain.dao.repository.user.RoleRepository;
import com.example.foodprojectmain.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User register(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            role = new Role();
            role.setName("ROLE_USER");
            roleRepository.save(role);
        }
        user.setRoleId(role.getId());
        user.setRole(role);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void createAdminIfNotExists() {
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepository.save(role);
        }
        User user = userRepository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setUsername("admin");
            user.setPassword(bCryptPasswordEncoder.encode("admin1"));
            user.setEmail("admin@example.com");
            user.setRoleId(role.getId());
            user.setRole(role);
            userRepository.save(user);
        }
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
