package value;
/* 
 * Artworks: to store and get the values from the database and input fields 
 */
public class ArtworksValues {
	private String  art_code,
					art_title,
					art_style,
					year_of_making,
					artist_id,
					art_status;
	private Float 	art_price;
	
	public void setArtCode(String ArtCode) {
		art_code = ArtCode;
	}
	
	public String getArtCode() {
		return art_code;
	}
	
	public void setArtTitle(String ArtTitle) {
		art_title = ArtTitle;
	}
	
	public String getArtTitle() {
		return art_title;
	}
	
	public void setArtStyle(String ArtStyle) {
		art_style = ArtStyle;
	}
	
	public String getArtStyle() {
		return art_style;
	}
	
	public void setYearOfMaking(String YearOfMaking) {
		year_of_making = YearOfMaking;
	}
	
	public String getYearOfMaking() {
		return year_of_making;
	}
	
	public void setArtistID(String ArtistID) {
		artist_id = ArtistID;
	}
	
	public String getArtistID() {
		return artist_id;
	}
	
	public void setArtStatus(String ArtStatus) {
		art_status = ArtStatus;
	}
	
	public String getArtStatus() {
		return art_status;
	}
	
	public void setArtPrice(Float ArtPrice) {
		art_price = ArtPrice;
	}
	
	public Float getArtPrice() {
		return art_price;
	}
	
}
