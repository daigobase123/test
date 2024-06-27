package com.example.test.handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.test.ConnectionProvide;
import com.example.test.beans.LoginUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
//	@Autowired
//    private LoginDao loginDao;
	
	 @Autowired
	 private ConnectionProvide connectionProvider;
	 
	 private static final String INSER_QUERY = "INSERT INTO t_login (username, success) Values(?, ?)";
	
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
        final Authentication authentication) throws IOException, ServletException {
    	
//    	トランサクションの保存
//    	LoginUser loginUser = this.loginDao.store(true);
    	String empName = SecurityContextHolder.getContext().getAuthentication().getName();
    	 try (Connection conn = connectionProvider.getConnection();
    	            PreparedStatement stmt = conn.prepareStatement(INSER_QUERY, Statement.RETURN_GENERATED_KEYS); ) {
    	            
    	            stmt.setString(1, "test");
    	            stmt.setBoolean(2, true);
    	            stmt.executeUpdate();   	            

    	       
    	        } catch (SQLException e) {
    	            throw new IllegalStateException(e);
    	        }
    	LoginUser loginUser = new LoginUser();
//    	 loginUser.setRoleId(1);
//         loginUser.setEmpNo("10");
//         loginUser.setEmpName("ter");
         
         Cookie cookie = new Cookie("empName", empName);
         response.addCookie(cookie);
//    
    	response.setStatus(HttpStatus.OK.value());
    }
}