package com.example.picpaysimplificado.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.picpaysimplificado.domain.user.User;
import com.example.picpaysimplificado.domain.user.UserType;
import com.example.picpaysimplificado.dtos.UserDTO;
import com.example.picpaysimplificado.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void validTransaction(User sender,BigDecimal amount) throws Exception {
		 if(sender.getUserType()== UserType.MERCHANT) {
			 throw new Exception("Usuario do tipo lojista não está autorizado a realizar transação");
		 }
		 
		 if(sender.getBalance().compareTo(amount)<0) {
			 throw new Exception("Saldo insuficiente");
		 }
	}
	
	public User findUserById(Long Id) throws Exception {
		return this.repository.findById(Id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
	}
	
	public void saveUser(User user) {
		this.repository.save(user);
	}
	
	public User createUser(UserDTO data) {
		
		User newUser = new User(data);
		this.saveUser(newUser);
		return newUser;
	}

	public List<User> getAllUsers() {
		
		return this.repository.findAll();
	}
}
