package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class AdminUserRestController {

    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminUserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/admin")
    public ResponseEntity<User> newUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PatchMapping("/admin/{id}")
    public ResponseEntity<User> updateUser (@RequestBody User user){
        userService.updateUser(user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> showAllUsers(){
        List<User> userList = userService.getAllUsers();
        return (userList != null && !userList.isEmpty() ? new ResponseEntity<>(userList, HttpStatus.OK)
                : new ResponseEntity<>(userList, HttpStatus.NOT_FOUND));
    }


}
