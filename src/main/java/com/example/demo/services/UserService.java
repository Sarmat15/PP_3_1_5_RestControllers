package com.example.demo.services;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {

     User findUserByUsername(String username);

 void saveUser(User user);

 void deleteUserById(Integer id);

 User getUserById(Integer id);

 User findByEmail(String name);

 void updateUser(User user);

 List<User> getAllUsers();
}
