package com.spring_concepts.Dao;

import com.spring_concepts.dto.UserDto;
import com.spring_concepts.services.MySqlConnection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
@AllArgsConstructor
public class UserDao {
    private final MySqlConnection connectionClass;
    
    public void insertUser(UserDto user) throws SQLException {
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String insertQuery = "INSERT INTO Users (name, email, id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getId());
        preparedStatement.executeUpdate();
    }
}
