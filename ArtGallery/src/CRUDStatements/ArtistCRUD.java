package CRUDStatements;

import connection.DBConnection;
import value.ArtistValues;
import value.ArtworksValues;

import java.sql.*;
import java.util.ArrayList;

public class ArtistCRUD {
	
	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
	/* 
	 				artist_name,
					artist_age,
					artist_gender,
					artist_address,
					artist_contactnum;
	*/
	
//READING	
	public static ArrayList <ArtistValues> Read() {
		
		ArrayList<ArtistValues> artistList = new ArrayList<ArtistValues>();
		
		try {
			conn =   DBConnection.getConnection();
			PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM artist");  
			ResultSetObject = SelectStatement.executeQuery();
			
			while(ResultSetObject.next()) {
				ArtistValues artist = new ArtistValues();
				artist.setArtistName(ResultSetObject.getString("ArtistName"));
				artist.setArtistAge(ResultSetObject.getString("ArtistAge"));
				artist.setArtistGender(ResultSetObject.getString("ArtistGender"));
				artist.setArtistAddress(ResultSetObject.getString("ArtistAddress"));
				artist.setArtistContactNumber(ResultSetObject.getString("ArtistContactNumber"));
				
				artistList.add(artist);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return artistList;
	}
	
//INSERTING another row in the table
	public static int Insert(ArtistValues artist) {
		conn = DBConnection.getConnection();
		int tableFill = 0;
		
		try {
			InsStatement = conn.prepareStatement("INSERT into artworks VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			InsStatement.setString(1, artist.getArtistName());
			InsStatement.setString(2, artist.getArtistAge());
			InsStatement.setString(3, artist.getArtistGender());
			InsStatement.setString(4, artist.getArtistAddress());
			InsStatement.setString(5, artist.getArtistContactNumber());
			
			tableFill = InsStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableFill;
	}
	
//UPDATING data
	public void Update() {
		
	}
	
//DELETING a row in the table
	public void Delete() {
		
	}
}
