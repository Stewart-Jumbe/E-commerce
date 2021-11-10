package com.qa.CustomerAccount.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.CustomerAccount.Domain.CustomerAccount;

@Repository
public interface CustomerAccountRepo extends JpaRepository<CustomerAccount, Integer> {

}
