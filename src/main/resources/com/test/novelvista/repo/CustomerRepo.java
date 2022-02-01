package com.test.novelvista.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.novelvista.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	
}