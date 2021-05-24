package value;

import java.sql.Date;

/* 
 * Sales: to store and get the values from the database and input fields 
 */
public class SalesValues {
	private String 	buyer_id,
					seller_id,
					art_code;
	private Integer	id;
	private Float 	amount;
	private Date 	dateOfsale;
	
	public void setId(Integer cartID) {
		id = cartID;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setSellerId(String SellerId) {
		 seller_id = SellerId;
	}
	
	public String getSellerId() {
		return seller_id;
	}
	
	public void setBuyerId(String BuyerId) {
		 buyer_id = BuyerId;
	}
	
	public String getBuyerId() {
		return buyer_id;
	}
	
	public void setArtCode(String ArtCode) {
		art_code = ArtCode;
	}
	
	public String getArtCode() {
		return art_code;
	}
	
	public void setAmount(Float Amount) {
		amount = Amount;
	}
	
	public Float getAmount() {
		return amount;
	}
	
	public void setDateOfSale(Date DateOfSale) {
		dateOfsale = DateOfSale;
	}
	
	public Date getDateOfSale() {
		return dateOfsale;
	}
}
