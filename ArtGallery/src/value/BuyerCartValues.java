package value;
/* 
 * BuyerCart: to store and get the values from the database and input fields 
 */
public class BuyerCartValues {
	private String 	art_code,
					buyer_id,
					payment_status;
	private Integer id;
	
	public void setId(Integer cartID) {
		id = cartID;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setArtCode(String ArtCode) {
		art_code = ArtCode;
	}
	
	public String getArtCode() {
		return art_code;
	}
	
	public void setBuyerId(String BuyerId) {
		 buyer_id = BuyerId;
	}
	
	public String getBuyerId() {
		return buyer_id;
	}
	
	public void setPaymentStatus(String PaymentStatus) {
		payment_status = PaymentStatus;
	}
	public String getPaymentStatus() {
		return payment_status;
	}

}
