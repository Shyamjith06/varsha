package com.mindtree.bankmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bankmanagement.entity.Bank;



@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

	Bank findBybankName(String bankName);

}
