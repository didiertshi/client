package pack1;

public class ProdInfo {
	String product_id;
	String account_id;
	String prod_menu;
	String prod_submenu;
	String prod_price;
	String prod_longitude;
	String prod_latitude;
	String prod_status;
	String prod_pic_id;
	String prod_telephone;
	
	public String getProduct_id() {
		return product_id;
	}

	public String getAccount_id() {
		return account_id;
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

	public String getProd_status() {
		return prod_status;
	}

	public String getProd_pic_id() {
		return prod_pic_id;
	}

	public String getProd_telephone() {
		return prod_telephone;
	}

	public ProdInfo(String product_id,String account_id,String prod_menu,String prod_submenu,String prod_price,String prod_longitude,String prod_latitude,String prod_status,String prod_pic_id,String prod_telephone){
		
		this.product_id = product_id;
		this.account_id = account_id;
		this.prod_menu = prod_menu;
		this.prod_submenu = prod_submenu;
		this.prod_price = prod_price ;
		this.prod_longitude = prod_longitude;
		this.prod_latitude = prod_latitude;
		this.prod_status = prod_status;
		this.prod_pic_id = prod_pic_id;
		this.prod_telephone = prod_telephone;
	}
	
}
