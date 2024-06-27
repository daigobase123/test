package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.beans.Employee;
import com.example.test.ConnectionProvide;

@Component
public class EmployeeDAO {
    // 全権
    private static final String SELECT_ALL_QUERY = "SELECT * FROM emp";

    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM emp WHERE emp_id = ?";

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM emp WHERE emp_id = ?";
    
    private static final String UPDATE_QUERY = "UPDATE emp SET  emp_no = ?, emp_name = ?, age = ?, gender = ?, zip = ?, pref_id = ?, address = ?, post_id = ?, ent_date = ?, ret_date = ? WHERE emp_id = ?";
    
    private static final String INSER_QUERY = "INSERT INTO emp(emp_no, emp_name, age, gender, zip, pref_id, address, post_id, ent_date, ret_date) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    @Autowired
    private ConnectionProvide connectionProvider;

    public List<Employee> findAll() {
        try (Connection conn = connectionProvider.getConnection();
            Statement stmt = conn.createStatement(); ) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
            
            List<Employee> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processRow(rs));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Employee findById(final int id) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY); ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Employee result = null;
            if (rs.next()) {
                result = processRow(rs);
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    public Employee findByCriteria(final Employee employee) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY); ) {
            stmt.setInt(1, employee.getEmpId());
            ResultSet rs = stmt.executeQuery();
            
            Employee result = null;
            if (rs.next()) {
                result = processRow(rs);
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    

    public boolean remove(final int id) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID_QUERY); ) {
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();

            return count == 1;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean update(final Employee employee) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY); ) {
            
            stmt.setString(1, employee.getEmpNo());
            stmt.setString(2, employee.getEmpName());
            stmt.setInt(3, employee.getAge());
            stmt.setInt(4, employee.getGender());
            stmt.setString(5, employee.getZip());
            stmt.setInt(6, employee.getPrefId());
            stmt.setString(7, employee.getAddress());
            stmt.setInt(8, employee.getPostId());
            stmt.setDate(9, (java.sql.Date) employee.getEntDate());
            stmt.setDate(10, (java.sql.Date) employee.getRetDate());
            stmt.setInt(11, employee.getEmpId());

            int count = stmt.executeUpdate();

            return count == 1;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    public Employee create(final Employee employee) {
        try (Connection conn = connectionProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSER_QUERY, Statement.RETURN_GENERATED_KEYS); ) {
            
            stmt.setString(1, employee.getEmpNo());
            stmt.setString(2, employee.getEmpName());
            stmt.setInt(3, employee.getAge());
            stmt.setInt(4, employee.getGender());
            stmt.setString(5, employee.getZip());
            stmt.setInt(6, employee.getPrefId());
            stmt.setString(7, employee.getAddress());
            stmt.setInt(8, employee.getPostId());
            stmt.setDate(9, (java.sql.Date) employee.getEntDate());
            stmt.setDate(10, (java.sql.Date) employee.getRetDate());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            employee.setEmpId(id);
            return employee;
            
       
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private Employee processRow(final ResultSet rs) throws SQLException{
        // TODO Auto-generated method stub
        Employee result = new Employee();
        result.setEmpId(rs.getInt("emp_id"));
        result.setEmpNo(rs.getString("emp_no"));
        result.setEmpName(rs.getString("emp_name"));
        result.setAge(rs.getInt("age"));
        result.setGender(rs.getInt("gender"));
        result.setZip(rs.getString("zip"));
        result.setPrefId(rs.getInt("pref_id"));
        result.setAddress(rs.getString("address"));
        result.setEntDate(rs.getDate("ent_date"));
        result.setRetDate(rs.getDate("ret_date"));

        return result;
    }
}
