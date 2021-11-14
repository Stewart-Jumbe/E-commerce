package com.qa.CustomerAccount.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.CustomerAccount.Domain.CustomerAccount;

@Repository //indicates that HumanRepo will be used as a repository for our database, enables database interactions e.g modification, queries... 
public interface CustomerAccountRepo extends JpaRepository<CustomerAccount, Integer> {// This is a repository of Customer Account, Integer relates to the data type of the id

}
