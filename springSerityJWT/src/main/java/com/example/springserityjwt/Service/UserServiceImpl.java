package com.example.springserityjwt.Service;

import com.example.springserityjwt.Entity.Role;
import com.example.springserityjwt.Entity.User;
import com.example.springserityjwt.Repository.RoleRepository;
import com.example.springserityjwt.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Service
@Slf4j

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email).get();
        Role role = roleRepository.findByName(roleName).get();
        user.getRoles().add(role);
    }
}
