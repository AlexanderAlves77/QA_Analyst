package com.fulldevstacks.qa_test_api.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fulldevstacks.qa_test_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findById(Long id);
	
	Optional<User> findByEmail(String email);
	
	List<User> findByNameContainingIgnoreCase(String name);
	
	List<User> findByActiveTrue();
	
	@Query("SELECT u FROM User u WHERE u.age >= :minAge AND u.age <= :maxAge")
	List<User> findByAgeBetween(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
	
	boolean existsByEmail(String email);
	
	long countByActive(boolean active);
}
