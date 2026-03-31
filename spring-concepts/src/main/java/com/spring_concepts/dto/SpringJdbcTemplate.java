package com.spring_concepts.dto;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SpringJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;

    public void insertUser(UserDto user) {
        System.out.println("Inserting user using Spring JdbcTemplate ");
        jdbcTemplate.update("INSERT INTO Users (name, email, id) VALUES (?, ?, ?)", user.getName(), user.getEmail(), user.getId());
    }

//    HikariDataSource
//    HikariPool: class to manage the DB connections pool
}


/*
    No DB Connections has been created, automatically handled by the Spring JDBC.
    Just autowire JDBCTemplate and use it, rest will take care by sping boot
 */