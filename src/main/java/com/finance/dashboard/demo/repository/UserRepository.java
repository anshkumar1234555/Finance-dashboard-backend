package com.finance.dashboard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.dashboard.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}