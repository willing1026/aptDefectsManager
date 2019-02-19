package com.defect.manager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.manager.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
