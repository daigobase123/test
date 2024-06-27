package com.example.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.test.ConnectionProvide;
import com.example.test.beans.MyUser;

@Component
public class UserDao {
	private static final String SELECT_BY_USERNAME_QUERY = "SELECT id, password FROM test WHERE id = ?";
	
	@Autowired
    private ConnectionProvide connectionProvider;
	
	public MyUser findById(final String id) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_USERNAME_QUERY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            MyUser result = null;
            if (rs.next()) {
                result = processRow(rs);
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
	
	private MyUser processRow(final ResultSet rs) throws SQLException{
		MyUser result = new MyUser();
        result.setId(rs.getString("id"));
        result.setPassword(rs.getString("password"));
     

        return result;
    }
}
