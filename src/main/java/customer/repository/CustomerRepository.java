package customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
