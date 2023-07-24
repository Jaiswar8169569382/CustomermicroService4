package customer.exception;

public class CustomerNotFound extends RuntimeException{

	public CustomerNotFound()
	{
		super("customer not found with register id");
	}
	
	public CustomerNotFound(String sms)
	{
		super(sms);
	}
}
