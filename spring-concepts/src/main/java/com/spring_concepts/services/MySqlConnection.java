package com.spring_concepts.services;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;

@Component
public final class MySqlConnection {
    private Connection connection;

    public Connection getConnection() {
        if(connection != null) return connection;
        try {
            Class.forName("java.sql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personal_Manoj_Dhiman", "root", "Manoj@12");
        } catch (Exception e) {
            System.out.println("Exception while establishing connection: " + e.getMessage());
        }
        return connection;
    }
}
