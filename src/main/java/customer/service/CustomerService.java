package customer.service;

import java.util.List;

import customer.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer custmer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomerById(String id);
	public List<Customer> findAllCustomer();
	public void deleteCustomer(String cid);
}
