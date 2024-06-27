package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConnectionProvide {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "user", "postgres");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
