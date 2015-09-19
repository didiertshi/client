package pack1;

public class AccountInfo {
	String account_id;
	String user_name;
	String password;
	String account_balance;
	String account_status;
	String account_op_status;
	String group_name;
	public String getAccount_id() {
		return account_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	public String getAccount_balance() {
		return account_balance;
	}
	public String getAccount_status() {
		return account_status;
	}
	public String getAccount_op_status() {
		return account_op_status;
	}
	public String getGroup_name() {
		return group_name;
	}
	
	
	public AccountInfo(String account_id,String user_name,String password,String account_balance,String account_status,String account_op_status,String group_name){
		
		this.account_id=account_id;
		this.user_name  = user_name;
		this.password = password;
		this.account_balance = account_balance;
		this.account_status = account_status;
		this.account_op_status = account_op_status;
		this.group_name = group_name;
		
	}

}
