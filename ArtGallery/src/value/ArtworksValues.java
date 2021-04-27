package value;
/* 
 * Artworks: to store and get the values from the database and input fields 
 */
public class ArtworksValues {
	private String  art_code,
					art_title,
					art_style,
					year_of_making,
					artist,
					art_status;
	private Float 	art_price;
	
	public String getArtCode() {
		return art_code;
	}
	
	public void setArtCode(String ArtCode) {
		art_code = ArtCode;
	}
	
	public String getArtTitle() {
		return art_title;
	}
	
	public void setArtTitle(String ArtTitle) {
		art_title = ArtTitle;
	}
	
	public String getArtStyle() {
		return art_style;
	}
	
	public void setArtStyle(String ArtStyle) {
		art_style = ArtStyle;
	}
	
	public String getYearOfMaking() {
		return year_of_making;
	}
	
	public void setYearOfMaking(String YearOfMaking) {
		year_of_making = YearOfMaking;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String paramArtist) {
		artist = paramArtist;
	}
	
	public String getArtStatus() {
		return art_status;
	}
	
	public void setArtStatus(String ArtStatus) {
		art_status = ArtStatus;
	}
	
	public Float getArtPrice() {
		return art_price;
	}
	
	public void setArtPrice(Float ArtPrice) {
		art_price = ArtPrice;
	}
}
