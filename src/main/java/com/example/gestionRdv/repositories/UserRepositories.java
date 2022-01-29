package com.example.gestionRdv.repositories;

import com.example.gestionRdv.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepositories extends JpaRepository<User,Long> {
 Optional<User> findByUsername(String username);


 @Query("SELECT u FROM User u WHERE u.role= :role")
 List<User> retrieveUsersByRole(@Param("role") String role);



}
