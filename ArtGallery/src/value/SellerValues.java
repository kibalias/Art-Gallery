package value;
/*
 * Sales: to store and get values in database and input fields
 */
public class SellerValues {
	private String seller_id,
					seller_name,
					seller_gender,
					seller_address,
					seller_city,
					seller_state,
					seller_zip,
					seller_contactnum;
	private Integer seller_age;
	
	public void setSellerId(String SellerId) {
		 seller_id = SellerId;
	}
	
	public String getSellerId() {
		return seller_id;
	}
	
	public void setSellerName(String SellerName) {
		 seller_name = SellerName;
	}
	
	public String getSellerName() {
		return seller_name;
	}
	
	public void setSellerAge(Integer SellerAge) {
		 seller_age = SellerAge;
	}
	
	public Integer getSellerAge() {
		return seller_age;
	}
	
	public void setSellerGender(String SellerGender) {
		 seller_gender = SellerGender;
	}
	
	public String getSellerGender() {
		return seller_gender;
	}
	
	public void setSellerAddress(String SellerAddress) {
		 seller_address = SellerAddress;
	}
	
	public String getSellerAddress() {
		return seller_address;
	}
	
	public void setSellerCity(String SellerCity) {
		 seller_city = SellerCity;
	}
	
	public String getSellerCity() {
		return seller_city;
	}
	
	public void setSellerState(String SellerState) {
		 seller_state = SellerState;
	}
	
	public String getSellerState() {
		return seller_state;
	}
	
	public void setSellerZIP(String SellerZIP) {
		 seller_zip = SellerZIP;
	}
	
	public String getSellerZIP() {
		return seller_zip;
	}
	
	public void setSellerContactNumber(String SellerContactNumber) {
		 seller_contactnum = SellerContactNumber;
	}
	
	public String getSellerContactNumber() {
		return seller_contactnum;
	}
}
