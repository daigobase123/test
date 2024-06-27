package com.example.test.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.test.beans.LoginUser;
import com.example.test.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
    private LoginDao loginDao;
	
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
        final Authentication authentication) throws IOException, ServletException {
    	
//    	トランサクションの保存
//    	LoginUser loginUser = this.loginDao.store(true);
    	LoginUser loginUser = new LoginUser();
    	 loginUser.setRoleId(1);
         loginUser.setEmpNo("10");
         loginUser.setEmpName("ter");
         
         Cookie cookie = new Cookie("user", "1");
         response.addCookie(cookie);
//    
    	response.setStatus(HttpStatus.OK.value());
    }
}