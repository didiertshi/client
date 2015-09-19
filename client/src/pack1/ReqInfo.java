package pack1;

public class ReqInfo {

	String request_id;
	String prod_menu;
	String prod_submenu;
	String prod_price;
	String prod_longitude;
	String prod_latitude;
	String prod_distance;
	String request_date;
	
	
	public String getRequest_id() {
		return request_id;
	}
	public String getProd_menu() {
		return prod_menu;
	}
	public String getProd_submenu() {
		return prod_submenu;
	}
	public String getProd_price() {
		return prod_price;
	}
	public String getProd_longitude() {
		return prod_longitude;
	}
	public String getProd_latitude() {
		return prod_latitude;
	}
	public String getProd_distance() {
		return prod_distance;
	}
	
	public String getrequest_date() {
		return request_date;
	}
	
public ReqInfo(String request_id,String prod_menu,String prod_submenu,String prod_price,String prod_longitude,String prod_latitude,String prod_distance,String request_date){
		
		this.request_id = request_id;
		this.prod_menu = prod_menu;
		this.prod_submenu = prod_submenu;
		this.prod_price = prod_price ;
		this.prod_longitude = prod_longitude;
		this.prod_latitude = prod_latitude;
		this.prod_distance = prod_distance;
		this.request_date = request_date;
	}
	
}
