package customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import customer.entity.Hotel;

@FeignClient(name ="HOTELMICRO")
public interface CustomerFiegn {

	@GetMapping("hotel/{hid}")
	public Hotel getHotelById(@PathVariable("hid") String hid);
}
