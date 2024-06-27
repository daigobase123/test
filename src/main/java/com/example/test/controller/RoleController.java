package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.beans.Role;
import com.example.test.dao.RoleDao;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
    private RoleDao roleDao;
	
	
   @GetMapping
    public List<Role> findAll() {
        return this.roleDao.findAll();
    }
}
