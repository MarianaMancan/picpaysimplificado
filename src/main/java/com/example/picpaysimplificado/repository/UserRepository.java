package com.example.picpaysimplificado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaysimplificado.domain.user.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findUserByDocument(String document);
	


}
