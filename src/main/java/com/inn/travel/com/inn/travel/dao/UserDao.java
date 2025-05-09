package com.inn.travel.com.inn.travel.dao;

import com.inn.travel.com.inn.travel.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmailId(@Param("emailId") String email);
}

