package com.cbar.orderhutbe.repository;

import com.cbar.orderhutbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
