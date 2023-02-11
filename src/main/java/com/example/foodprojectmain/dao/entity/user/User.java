package com.example.foodprojectmain.dao.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Role role;

    // other attributes and getters/setters
}

