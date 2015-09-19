package pack1;

public class SponsorInfo {
	String sponsor_id;
	String account_id;
	String priority;
	String picture_id;
	String status;
	String s_longitude;
	String s_latitude;
	String date_time;
	
	public String getSponsor_id() {
		return sponsor_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public String getPriority() {
		return priority;
	}
	public String getPicture_id() {
		return picture_id;
	}
	public String getStatus() {
		return status;
	}
	public String getS_longitude() {
		return s_longitude;
	}
	public String getS_latitude() {
		return s_latitude;
	}
	public String getDate_time() {
		return date_time;
	}

public SponsorInfo(String sponsor_id,String account_id,String priority,String picture_id,String status,String s_longitude,String s_latitude,String date_time){
		
		this.sponsor_id = sponsor_id;
		this.account_id = account_id;
		this.priority = priority;
		this.picture_id ="/images/"+ picture_id;
		this.status = status ;
		this.s_longitude = s_longitude;
		this.s_latitude = s_latitude;
		this.date_time = date_time;
		
	}
	
}
