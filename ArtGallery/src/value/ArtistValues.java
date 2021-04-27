package value;
/* 
 * Artist: to store and get the values from the database and input fields 
 */
public class ArtistValues {
	private String artist_name,
					artist_age,
					artist_gender,
					artist_address,
					artist_contactnum;

	public void setArtistName(String ArtistName) {
		 artist_name = ArtistName;
	}
	
	public String getArtistName() {
		return artist_name;
	}
	
	public void setArtistAge(String ArtistAge) {
		artist_age = ArtistAge;
	}
	
	public String getArtistAge() {
		return artist_age;
	}
	
	public void setArtistGender(String ArtistGender) {
		artist_gender = ArtistGender;
	}
	
	public String getArtistGender() {
		return artist_gender;
	}
	
	public void setArtistAddress(String ArtistAddress) {
		artist_address = ArtistAddress;
	}
	
	public String getArtistAddress() {
		return artist_address;
	}
	
	public void setArtistContactNumber(String ArtistContactNumber) {
		artist_contactnum = ArtistContactNumber;
	}
	
	public String getArtistContactNumber() {
		return artist_contactnum;
	}
}
