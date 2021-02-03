package com.customer.repository;

<<<<<<< HEAD
import org.springframework.data.repository.CrudRepository;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> practise
import org.springframework.stereotype.Repository;

import com.customer.datamodel.Customer;

@Repository
<<<<<<< HEAD
public interface CustomerRepository extends CrudRepository<Customer, Long> {
=======
public interface CustomerRepository extends JpaRepository<Customer, Long> {
>>>>>>> practise

}
