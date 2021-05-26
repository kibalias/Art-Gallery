package value;
/* 
 * Buyer: to store and get the values from the database and input fields 
 */
public class BuyerValues {
	private String 	buyer_id,
					buyer_name,
					buyer_gender,
					buyer_address,
					buyer_city,
					buyer_state,
					buyer_zip,
					buyer_contactnum;
	private Integer buyer_age;
	
	public void setBuyerId(String BuyerId) {
		 buyer_id = BuyerId;
	}
	
	public String getBuyerId() {
		return buyer_id;
	}
	
	public void setBuyerName(String BuyerName) {
		 buyer_name = BuyerName;
	}
	
	public String getBuyerName() {
		return buyer_name;
	}
	
	public void setBuyerAge(Integer BuyerAge) {
		 buyer_age = BuyerAge;
	}
	
	public Integer getBuyerAge() {
		return buyer_age;
	}
	
	public void setBuyerGender(String BuyerGender) {
		 buyer_gender = BuyerGender;
	}
	
	public String getBuyerGender() {
		return buyer_gender;
	}
	
	public void setBuyerAddress(String BuyerAddress) {
		 buyer_address = BuyerAddress;
	}
	
	public String getBuyerAddress() {
		return buyer_address;
	}
	
	public void setBuyerCity(String BuyerCity) {
		 buyer_city = BuyerCity;
	}
	
	public String getBuyerCity() {
		return buyer_city;
	}
	
	public void setBuyerState(String BuyerState) {
		 buyer_state = BuyerState;
	}
	
	public String getBuyerState() {
		return buyer_state;
	}
	
	public void setBuyerZIP(String BuyerZIP) {
		buyer_zip = BuyerZIP;
	}
	
	public String getBuyerZIP() {
		return buyer_zip;
	}
	
	public void setBuyerContactNumber(String BuyerContactNumber) {
		 buyer_contactnum = BuyerContactNumber;
	}
	
	public String getBuyerContactNumber() {
		return buyer_contactnum;
	}
}
