package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Use JPQL with case-insensitivity for email
	@Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
	User findByEmail(@Param("email") String email);


}
