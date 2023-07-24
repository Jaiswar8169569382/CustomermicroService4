package customer.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.entity.Customer;
import customer.exception.CustomerNotFound;
import customer.repository.CustomerRepository;
import customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		
		String customerId=UUID.randomUUID().toString();
	    customer.setCid(customerId);
	    Customer customers=this.customerRepository.save(customer);
	    
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(String id) {
		return this.customerRepository.findById(id).orElseThrow(()->new CustomerNotFound("Customer not found with regster id"));
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return this.customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(String cid) {
		// TODO Auto-generated method stub
		this.customerRepository.deleteById(cid);
	}

	
}
