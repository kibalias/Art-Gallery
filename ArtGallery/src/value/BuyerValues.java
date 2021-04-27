package value;
/* 
 * Buyer: to store and get the values from the database and input fields 
 */
public class BuyerValues {
	private String 	buyer_id,
					buyer_name,
					buyer_age,
					buyer_gender,
					buyer_address,
					buyer_affiliation,
					buyer_contactnum;
	
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
	
	public void setBuyerAge(String BuyerAge) {
		 buyer_age = BuyerAge;
	}
	
	public String getBuyerAge() {
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
	
	public void setBuyerAffiliation(String BuyerAffiliation) {
		 buyer_affiliation = BuyerAffiliation;
	}
	
	public String getBuyerAffiliation() {
		return buyer_affiliation;
	}
	
	public void setBuyerContactNumber(String BuyerContactNumber) {
		 buyer_contactnum = BuyerContactNumber;
	}
	
	public String getBuyerContactNumber() {
		return buyer_contactnum;
	}
}
