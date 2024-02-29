package com.cafemanagement.CafeManagementSystem.repository;

import com.cafemanagement.CafeManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
