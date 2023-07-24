package customer.entity;

public class Rating {

	private String rid;
	private int rating;
	private String userid;
	private String hotelid;
	private String feedback;
	private Hotel hotel;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(String rid, int rating, String userid, String hotelid, String feedback) {
		super();
		this.rid = rid;
		this.rating = rating;
		this.userid = userid;
		this.hotelid = hotelid;
		this.feedback = feedback;
	}

	
	public Rating(String rid, int rating, String userid, String hotelid, String feedback, Hotel hotel) {
		super();
		this.rid = rid;
		this.rating = rating;
		this.userid = userid;
		this.hotelid = hotelid;
		this.feedback = feedback;
		this.hotel = hotel;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
