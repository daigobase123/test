package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.beans.LoginUser;
import com.example.test.dao.LoginDao;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private LoginDao loginDao;
		
	@Autowired
	PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String helloWorld(Model model) {
        return "index";
    }
    
    @GetMapping("/hello")
    @PreAuthorize("hasRole('test')")
    public String Hello(Model model) {
        return passwordEncoder.encode("password");
    }
    
    @GetMapping("/test")
    public String Test(Model model) {
        return passwordEncoder.encode("password");
    }
    @GetMapping("/test2")
    public String Test2(Model model) {
        return passwordEncoder.encode("password");
    }
    
    @GetMapping("/sucess")
    public LoginUser Sucess() {
        return this.loginDao.store(true);
    }
    
}