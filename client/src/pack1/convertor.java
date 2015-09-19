package pack1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@ManagedBean
@ViewScoped
public class convertor {
	
	
	
	private String country;
	private String province;
	private String city;
	private String area;
	private String intersection;
	private String longitude;
	private String latitude;
	private String menu;
	private String submenu;
	private String price;
	private String phone;
	

	private String accid;
	private String fileName;
	private String vlongitude;
	private String vlatitude;
	private String vmenu;
	private String vsubmenu;
	private String delprodid;
	private String acountbal;
	private String pin_num;
	private String dist;
	private String rec1;
	private String vrec;
	
	public String getRec1() {
		return rec1;
	}

	public void setRec1(String rec1) {
		this.rec1 = rec1;
	}


	double delta ;
	private String vdistance;
	private String vlongitude2;
	
	public String getdist() {
		return dist;
	}

	public void setdist(String dist) {
		this.dist = dist;
	}


	private String tdist="500";
	double longinum;
	//private List displProd = new ArrayList();
	
	
	
	
	
	
	//delta = 9*(distnum /800) ;

	java.sql.Connection con = null;
	String url = "jdbc:mysql://localhost:3306/vex";
	String driver ="com.mysql.jdbc.Driver";
	String userName ="root";
	String password="admin";
	int sumcount =0;
	
	java.sql.Statement st;
	
	
	String query = "select * from countries";
	//String query2 = "select * from province where country_id = '" +country +"'";
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(); 
	String username = request.getRemoteUser(); 
	
	String query10 = "select * from account where user_name = '"+ username+"'";
	String sql12= "insert into product (account_id,prod_menu,prod_submenu,prod_price,prod_longitude,prod_latitude,prod_status,prod_pic_id,prod_telephone)values (?,?,?,?,?,?,?,?,?)";
	
	
	
	
    
    
    
    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }
    public String getprovince() {
        return province;
    }
    public void setprovince(String province) {
        this.province = province;
    }
    public String getcity() {
        return city;
    }
    public void setcity(String city) {
        this.city = city;
    }
    public String getarea() {
        return area;
    }
    public void setarea(String area) {
        this.area = area;
    }
    
    public String getintersection() {
        return intersection;
    }
    public void setintersection(String intersection) {
        this.intersection = intersection;
    }
    
    public String getlongitude() {
        return longitude;
    }
    public void setlongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public String getlatitude() {
        return latitude;
    }
    public void setlatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getmenu() {
        return menu;
    }
    public void setmenu(String menu) {
        this.menu = menu;
    }
    
    public String getsubmenu() {
        return submenu;
    }
    public void setsubmenu(String submenu) {
        this.submenu = submenu;
    }
    
    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }
    
    public String getphone() {
        return phone;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    
    public String getpin_num() {
        return pin_num;
    }
    public void setpin_num(String pin_num) {
        this.pin_num =pin_num;
    }
    
    
    
    
	// menues choices
	
	public List<SelectItem> getdistances(){
    	String query9 = "select * from distance";
    	ArrayList<SelectItem> distances = new ArrayList<SelectItem>();
    	distances.add(new SelectItem("0","--- Select Distance ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query9);
    		while (rs.next()) {
    			distances.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return distances;
    }     
	
    // record
	
	public List<SelectItem> getrecords(){
    	String query9 = "select * from record";
    	ArrayList<SelectItem> records = new ArrayList<SelectItem>();
    	records.add(new SelectItem("0","--- Select number of records ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query9);
    		while (rs.next()) {
    			records.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return records;
    }     
    public List<SelectItem> getcountries(){
    	ArrayList<SelectItem> countries = new ArrayList<SelectItem>();
    	countries.add(new SelectItem("0","--- Select country ---"));
    	try {
    		
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query);
    		while (rs.next()) {
    			countries.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return countries;
    }
    public List<SelectItem> getprovinces(){
    	String query2 = "select * from province where country_id = '" +country +"'";
    	ArrayList<SelectItem> provinces = new ArrayList<SelectItem>();
    	provinces.add(new SelectItem("0","--- Select province ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query2);
    		while (rs.next()) {
    			provinces.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return provinces;
    } 
    public List<SelectItem> getcities(){
    	String query3 = "select * from city where province_id = '" +province +"'";
    	ArrayList<SelectItem> cities = new ArrayList<SelectItem>();
    	cities.add(new SelectItem("0","--- Select city ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query3);
    		while (rs.next()) {
    			cities.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return cities;
    } 
   
    public List<SelectItem> getareas(){
    	String query4 = "select * from area where city_id = '" +city +"'";
    	ArrayList<SelectItem> areas = new ArrayList<SelectItem>();
    	areas.add(new SelectItem("0","--- Select area ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query4);
    		while (rs.next()) {
    			areas.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return areas;
    } 
    
    public List<SelectItem> getintersections(){
    	String query5 = "select * from intersection where area_id = '" +area +"'";
    	ArrayList<SelectItem> intersections = new ArrayList<SelectItem>();
    	intersections.add(new SelectItem("0","--- Select intersection ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query5);
    		while (rs.next()) {
    			intersections.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return intersections;
    } 
    
    public List<SelectItem> getlongitudes(){
    	String query6 = "select * from gps where intersection_id = '" +intersection +"'";
    	ArrayList<SelectItem> longitudes = new ArrayList<SelectItem>();
    	longitudes.add(new SelectItem("0","--- Select longitude ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query6);
    		while (rs.next()) {
    			longitudes.add(  new SelectItem(rs.getString(1),rs.getString(4)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return longitudes;
    }     
    
    public List<SelectItem> getlatitudes(){
    	String query7 = "select * from gps where intersection_id = '" +intersection +"'";
    	ArrayList<SelectItem> latitudes = new ArrayList<SelectItem>();
    	latitudes.add(new SelectItem("0","--- Select latitude ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query7);
    		while (rs.next()) {
    			latitudes.add(  new SelectItem(rs.getString(1),rs.getString(5)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return latitudes;
    }     
    
    public List<SelectItem> getmenues(){
    	String query8 = "select * from menu";
    	ArrayList<SelectItem> menues = new ArrayList<SelectItem>();
    	menues.add(new SelectItem("0","--- Select Category ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query8);
    		while (rs.next()) {
    			menues.add(  new SelectItem(rs.getString(1),rs.getString(2)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return menues;
    }   
    
    public List<SelectItem> getsubmenues(){
    	String query9 = "select * from sub_menu where menus_id = '" +menu +"'";
    	ArrayList<SelectItem> submenues = new ArrayList<SelectItem>();
    	submenues.add(new SelectItem("0","--- Select Subcategory ---"));
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query9);
    		while (rs.next()) {
    			submenues.add(  new SelectItem(rs.getString(1),rs.getString(3)));
    		}
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return submenues;
    }     
    public void submit() throws IOException{
		File file = null;
		File file2 = null;
        OutputStream output = null;
        OutputStream output2 = null;
     // Just to demonstrate what information you can get from the uploaded file.
        
        // Prepare filename prefix and suffix for an unique filename in upload folder.
        
        // get account ID
        try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query10);
                rs.next();
                accid = rs.getString(1);
    		
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

		try {
			// Create file with unique name in upload folder and write to it.
            
            // Show succes message.
            FacesContext.getCurrentInstance().addMessage("country", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));
			
		}finally {
			 
		}
		
		//Get longitude
		try{
			String query13 = "select * from gps where gps_id = '" +longitude +"'";
			Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query13);
                rs.next();
                vlongitude = rs.getString(4);
                rs.close();
                st.close();
                con.close();
		}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		// get latitude
try{
	String query14 = "select * from gps where gps_id = '" +latitude +"'";
	Class.forName(driver).newInstance();
	con = DriverManager.getConnection(url,userName,password);
	st = con.createStatement();
	java.sql.ResultSet rs = st.executeQuery(query14);
        rs.next();
        vlatitude = rs.getString(5);
        rs.close();
        st.close();
        con.close();	
			
		}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

// get menu
try{
	String query15 = "select * from menu where menus_id = '" +menu +"'";
	Class.forName(driver).newInstance();
	con = DriverManager.getConnection(url,userName,password);
	st = con.createStatement();
	java.sql.ResultSet rs = st.executeQuery(query15);
        rs.next();
        vmenu = rs.getString(2);
        rs.close();
        st.close();
        con.close();	
	
}catch(Exception ex) {
    System.out.println(ex.getMessage());
}
// get submenu
try{
	String query16 = "select * from sub_menu where sub_menu_id = '" +submenu +"'";
	Class.forName(driver).newInstance();
	con = DriverManager.getConnection(url,userName,password);
	st = con.createStatement();
	java.sql.ResultSet rs = st.executeQuery(query16);
        rs.next();
        vsubmenu = rs.getString(3);
        rs.close();
        st.close();
        con.close();		
	
}catch(Exception ex) {
    System.out.println(ex.getMessage());
}
		
		//insert record to mysql
		try {
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,userName,password);
			java.sql.PreparedStatement pst = con.prepareStatement(sql12);
			pst.setString(1, accid);
			pst.setString(2, vmenu);
			pst.setString(3, vsubmenu);
			pst.setString(4, price);
			pst.setString(5, vlongitude);
			pst.setString(6, vlatitude);
			pst.setString(7, "on");
			pst.setString(8, fileName);
			pst.setString(9, phone);

			int numRowsChange = pst.executeUpdate();
			pst.close();
            con.close();
			
		}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
	}
    
    //Display and delete products
    public List getdisplProd(){
    	ArrayList  displProd = new ArrayList();
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query10);
                rs.next();
                accid = rs.getString(1);
    		
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    	
    	try {
    		String query17 = "select * from product where account_id = '" +accid +"'";	
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query17);
    		while (rs.next()) {
    			displProd.add(  new ProdInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(11)));
    			
    		}
    		rs.close();
            st.close();
            con.close();
    		
    	}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	
    	
    	return displProd;	
    }
    
    // Display request
    
    public List getreqProd(){
    	
    	
    	ArrayList  reqProd = new ArrayList();
    	//Get longitude
    			try{
    				String query13 = "select * from gps where intersection_id = '"+intersection+"'";
    				Class.forName(driver).newInstance();
    	    		con = DriverManager.getConnection(url,userName,password);
    	    		st = con.createStatement();
    	    		java.sql.ResultSet rs = st.executeQuery(query13);
    	                rs.next();
    	                vlongitude = rs.getString(4);
    	                // longinum = Double.valueOf(vlongitude);
    	                rs.close();
    	                st.close();
    	                con.close();
    	                
    			}catch(Exception ex) {
    	            System.out.println(ex.getMessage());
    	        }
    			// get latitude
    	try{
    		String query14 = "select * from gps where intersection_id = '"+intersection+"'";
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query14);
    	        rs.next();
    	        vlatitude = rs.getString(5);
    	        rs.close();
    	        st.close();
    	        con.close();	
    				
    			}catch(Exception ex) {
    	            System.out.println(ex.getMessage());
    	        }
    	// get distance
    	try{
    		String query25 = "select * from distance where distance_id = '"+dist+"'" ;
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query25);
    	        rs.next();
    	        vdistance= rs.getString(2);
    	        rs.close();
    	        st.close();
    	        con.close();	
    		
    	}catch(Exception ex) {
    	    System.out.println(ex.getMessage());
    	}
// record
    	
    	
    	

    	
    	
    	// get submenu
    	try{
    		String query16 = "select * from sub_menu where sub_menu_id = '" +submenu +"'";
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query16);
    	        rs.next();
    	        vsubmenu = rs.getString(3);
    	        rs.close();
    	        st.close();
    	        con.close();		
    		
    	}catch(Exception ex) {
    	    System.out.println(ex.getMessage());
    	}
    	
    	// get record number
    	
    	try{
    		String query16 = "select * from record where record_id = '" +rec1 +"'";
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query16);
    	        rs.next();
    	        vrec = rs.getString(2);
    	        rs.close();
    	        st.close();
    	        con.close();		
    		
    	}catch(Exception ex) {
    	    System.out.println(ex.getMessage());
    	}
    	
    	   // testing zone
try {
	String sql122= "insert into templong (longit)values (?)";
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,userName,password);
			java.sql.PreparedStatement pst = con.prepareStatement(sql122);
			pst.setString(1, vrec);
			
			int numRowsChange = pst.executeUpdate();
			pst.close();
            con.close();
			
		}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	// end testing
    	try {
    		
    	    		
    		String query28 = "SELECT * FROM request WHERE prod_submenu = '"+vsubmenu+"'AND prod_longitude > ('"+vlongitude+"'-('"+vdistance+"'/100)) AND prod_longitude < ('"+vlongitude+"'+('"+vdistance+"'/100)) AND prod_latitude > ('"+vlatitude+"'-('"+vdistance+"'/100))AND prod_latitude < ('"+vlatitude+"'+('"+vdistance+"'/100))ORDER BY request_id DESC";
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query28);
    		
    		while (rs.next()) {
    			reqProd.add(  new ReqInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
    			
    		}
    		rs.close();
            st.close();
            con.close();
    		
    	}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
		return reqProd;
    }
    public void deleteProd(ProdInfo item){
    	delprodid= item.getProduct_id();
    	// String query18 = "delete  from product where product_id = '" +delprodid +"'";	
    	
    	 
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		
    		String query18 = "DELETE  FROM product WHERE prod_id = ?";	
    		int prod_id = Integer.parseInt(delprodid);
       	  //  int prod_id= 40;
    		java.sql.PreparedStatement pst = con.prepareStatement(query18);
    		
    		pst.setInt(1, prod_id);
    		int numRowsChange = pst.executeUpdate();
            System.out.println(numRowsChange+ "record deleted ")  ;  
            
    		pst.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    }
    
    public List getdisplaccount(){
    	ArrayList  displaccount = new ArrayList();
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query10);
                rs.next();
                accid = rs.getString(1);
    		
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	try {
    		String query17 = "select * from account where account_id = '" +accid +"'";	
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query17);
    		while (rs.next()) {
    			displaccount.add(  new AccountInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
    			
    		}
    		rs.close();
            st.close();
            con.close();
    		
    	}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	return displaccount;
    }
    
    public void loadpin(AccountInfo item) throws IOException{
    	try{
    		int pinValue = Integer.parseInt(pin_num);
    		accid= item.getAccount_id();
    		int accidValue = Integer.parseInt(accid);
    		
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		CallableStatement call = con.prepareCall("{call routine2(?,?)}");
    		call.setInt(1, pinValue);
    		call.setInt(2, accidValue);
    		
    		int update = call.executeUpdate();
    		System.out.println("Update: "+update);
    		con.close();
    		
    	}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    }
    
    
    //Display cdr
    
    public List getdisplcdr(){
    	ArrayList  displcdr = new ArrayList();
    	try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query10);
                rs.next();
                accid = rs.getString(1);
    		
    		rs.close();
            st.close();
            con.close();
    	}
    	catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	try {
    		String query17 = "select * from cdr where account_id = '" +accid +"'";	
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url,userName,password);
    		st = con.createStatement();
    		java.sql.ResultSet rs = st.executeQuery(query17);
    		while (rs.next()) {
    			displcdr.add(  new CdrInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
    			
    		}
    		rs.close();
            st.close();
            con.close();
    		
    	}catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    	
    	
    	
    	
    	return displcdr;
    }
   
    
}


