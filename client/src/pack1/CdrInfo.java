package pack1;

public class CdrInfo {
	
	String cdr_id;
	String date_time;
	String account_id;
	String prod_pic_id;
	String rate;
	String account_bal;
	
	public String getCdr_id() {
		return cdr_id;
	}
	public String getDate_time() {
		return date_time;
	}
	public String getAccount_id() {
		return account_id;
	}
	public String getProd_pic_id() {
		return prod_pic_id;
	}
	public String getRate() {
		return rate;
	}
	public String getAccount_bal() {
		return account_bal;
	}
	
	
	public CdrInfo(String cdr_id,String date_time,String account_id,String prod_pic_id,String rate,String account_bal){
		this.cdr_id = cdr_id;
		this.date_time = date_time;
		this.account_id = account_id;
		this.prod_pic_id = "/images/"+prod_pic_id;
		this.rate = rate;
		this.account_bal = account_bal;
		
	}

}
