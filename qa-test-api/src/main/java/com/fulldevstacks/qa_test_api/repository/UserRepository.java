package com.fulldevstacks.qa_test_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fulldevstacks.qa_test_api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	
}
