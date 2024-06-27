package com.example.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.test.ConnectionProvide;
import com.example.test.beans.LoginUser;

@Component
public class LoginDao {
	
    @Autowired
    private ConnectionProvide connectionProvider;
    
    private static final String INSER_QUERY = "INSERT INTO t_login(emp_name, success) Values(?, ?)";

    public LoginUser store(final Boolean sccess) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSER_QUERY, Statement.RETURN_GENERATED_KEYS); ) {
            
//        	LoginTransaction loginTransaction = new LoginTransaction();
        	LoginUser loginUser = new LoginUser();
        	
//        	 String empName = SecurityContextHolder.getContext().getAuthentication().getName();
//	
//            stmt.setString(1, empName);
//            stmt.setBoolean(2, sccess);
//            stmt.executeUpdate();
//            
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            int id = rs.getInt(1);
//            loginTransaction.setId(id);
//            loginTransaction.setUsername(empName);
//            loginTransaction.setSuccess(sccess);
//            loginTransaction.setTimeStamp(rs.getDate(4));
            
            loginUser.setRoleId(1);
            loginUser.setEmpNo("10");
            loginUser.setEmpName("ter");
            
            return loginUser;
            
       
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        
    }
    
}
