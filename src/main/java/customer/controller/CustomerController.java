package customer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import customer.entity.Customer;
import customer.entity.Hotel;
import customer.entity.Rating;
import customer.service.CustomerFiegn;
import customer.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerFiegn feign;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
	{
		Customer customers=this.customerService.saveCustomer(customer);
		
		
		return new ResponseEntity<Customer>(customers,HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		Customer customers=this.customerService.saveCustomer(customer);
		return ResponseEntity.ok(customers);
	}
	
	//int retrycount=0;
	@GetMapping("/{cid}")
    @CircuitBreaker(name = "ratinghotelbreaker", fallbackMethod = "dummy")
	//@Retry(name = "ratinghotelbreaker", fallbackMethod = "dummy")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") String cid)
	{
//		retrycount++;
//		System.out.println("attempts..."+retrycount);
		Customer customer=this.customerService.getCustomerById(cid);
		Rating[] rating=this.restTemplate.getForObject("http://RATINGMICRO/rating/user/"+cid, Rating[].class);
		
		List<Rating> ratingList=Arrays.asList(rating);
		for(Rating rat:ratingList)
		{
			//ResponseEntity<Hotel> hotel=this.restTemplate.getForEntity("http://HOTELMICRO/hotel/"+rat.getHotelid(), Hotel.class);
		   Hotel hotels=feign.getHotelById(rat.getHotelid());
			//Hotel hotels=hotel.getBody();
		   rat.setHotel(hotels);
		}
		customer.setRating(ratingList);
		return ResponseEntity.ok(customer);
	}
	
	public ResponseEntity<Customer> dummy(String cid,Exception ex)
	{
		Customer cust = new Customer();
		cust.setCid("123456");
		cust.setName("Dummy");
		cust.setEmail("dummy211@gmail.com");
		cust.setAbout("this is dummy data because server down");
		ex.printStackTrace();
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Customer>> findAllCustomer()
	{
		List<Customer> customerlist=this.customerService.findAllCustomer();
		return ResponseEntity.ok(customerlist);
	}
	
	@DeleteMapping("/{cid}")
	public void deleteCustomer(@PathVariable("cid") String cid)
	{
		this.customerService.deleteCustomer(cid);
	}
}
