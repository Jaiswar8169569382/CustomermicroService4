package customer.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<Map<String, Object>> UserNotFoundWithRegisterId(CustomerNotFound ex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("content", ex.getMessage());
		map.put("success", true);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
}
