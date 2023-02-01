package com.example.demo.services;

import com.example.demo.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {


    List<Role> findAllRoles();

}
