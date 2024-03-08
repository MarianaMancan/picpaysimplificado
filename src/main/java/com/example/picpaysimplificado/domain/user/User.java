package com.example.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import org.hibernate.dialect.Database;

import com.example.picpaysimplificado.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

@Entity(name="users")
@Table(name="users")
@EqualsAndHashCode(of="id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String fistName;
	
	private String lastName;
	
	@Column(unique=true)
	private String document;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private BigDecimal balance;
	
	private UserType userType;
	

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public User() {
		super();
	}

	public  User(UserDTO data) {
		this.fistName = data.firstName();
		this.lastName = data.lastName();
		this.balance = data.balance();
		this.userType = data.usertype();
		this.password = data.password();
		this.email = data.email();
		this.document = data.document();
		
	}
	
	
}


