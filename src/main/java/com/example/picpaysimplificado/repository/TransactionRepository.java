package com.example.picpaysimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaysimplificado.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	

}
