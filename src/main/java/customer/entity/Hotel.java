package customer.entity;

public class Hotel {
	private String hotelid;
	private String name;
	private String location;
	private String about;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(String hotelid, String name, String location, String about) {
		super();
		this.hotelid = hotelid;
		this.name = name;
		this.location = location;
		this.about = about;
	}
	public Hotel(String name, String location, String about) {
		super();
		this.name = name;
		this.location = location;
		this.about = about;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
