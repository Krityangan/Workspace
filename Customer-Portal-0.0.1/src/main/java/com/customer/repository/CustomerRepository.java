package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.datamodel.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
