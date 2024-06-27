package com.example.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.test.ConnectionProvide;
import com.example.test.beans.Role;

@Component
public class RoleDao {
	private static final String SELECT_ALL_QUERY = "SELECT id, role_name FROM role";
	
	@Autowired
    private ConnectionProvide connectionProvider;
	
	public List<Role> findAll() {
		try (Connection conn = connectionProvider.getConnection();
            Statement stmt = conn.createStatement(); ) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
        
            List<Role> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processRow(rs));
            }
            return result;

	        } catch (SQLException e) {
	            throw new IllegalStateException(e);
	        }
    }
	
	private Role processRow(final ResultSet rs) throws SQLException{
		Role result = new Role();
        result.setRoleId(rs.getInt("id"));
        result.setRoleName(rs.getString("role_name"));
     

        return result;
    }
}
