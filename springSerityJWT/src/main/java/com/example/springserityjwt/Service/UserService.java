package com.example.springserityjwt.Service;

import com.example.springserityjwt.Entity.Role;
import com.example.springserityjwt.Entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String userName, String roleName);
}
