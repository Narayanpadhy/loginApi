package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.user;

@Repository
public interface userRepo extends JpaRepository<user, Integer>{

	Boolean existsByUserName(String userName);

	Optional<user> findByUserName(String userName);

}
