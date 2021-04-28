package CRUDStatements;

import connection.DBConnection;
import value.ArtistValues;

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
	
	
//getByArtistName
	public ArtistValues artistVal (String ArtistName){
		ArtistValues artist = new ArtistValues();
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM artist WHERE ArtistName = '" + ArtistName +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
				
			if(ResultSetObject.next()) {
				artist.setArtistName(ResultSetObject.getString("ArtistName"));
				artist.setArtistAge(ResultSetObject.getString("ArtistAge"));
				artist.setArtistGender(ResultSetObject.getString("ArtistGender"));
				artist.setArtistAddress(ResultSetObject.getString("ArtistAddress"));
				artist.setArtistContactNumber(ResultSetObject.getString("ArtistContactNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artist;
	}
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
			InsStatement = conn.prepareStatement("INSERT into artist VALUES (?, ?, ?, ?, ?)");
			
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
	public static void Update(ArtistValues artist) {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE artist SET ArtistAge = ?, "
																	+ "ArtistGender = ?, "
																	+ "ArtistAddress = ?, "
																	+ "ArtistContactNumber = ? "
																	+ "WHERE ArtistName = ?");
			
			UpdateStatement.setString(5, artist.getArtistName());
			UpdateStatement.setString(1, artist.getArtistAge());
			UpdateStatement.setString(2, artist.getArtistGender());
			UpdateStatement.setString(3, artist.getArtistAddress());
			UpdateStatement.setString(4, artist.getArtistContactNumber());
			
			UpdateStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//DELETING a row in the table
	public void Delete(String ArtistName) {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `artist` WHERE `ArtistName` = ?");
			
			DeleteStatement.setString(1, ArtistName);
			DeleteStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
