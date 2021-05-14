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
	
	
//getByArtistID
	public ArtistValues artistVal (String ArtistID){
		ArtistValues artist = new ArtistValues();
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM artist WHERE ArtistID = '" + ArtistID +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
				
			if(ResultSetObject.next()) {
				artist.setArtistID(ResultSetObject.getString("ArtistID"));
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
				artist.setArtistID(ResultSetObject.getString("ArtistID"));
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
			InsStatement = conn.prepareStatement("INSERT into artist VALUES (?, ?, ?, ?, ?, ?)");
			InsStatement.setString(1, artist.getArtistID());
			InsStatement.setString(2, artist.getArtistName());
			InsStatement.setString(3, artist.getArtistAge());
			InsStatement.setString(4, artist.getArtistGender());
			InsStatement.setString(5, artist.getArtistAddress());
			InsStatement.setString(6, artist.getArtistContactNumber());
			
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
			PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE artist SET ArtistName = ?, "
																	+ "ArtistAge = ?, "
																	+ "ArtistGender = ?, "
																	+ "ArtistAddress = ?, "
																	+ "ArtistContactNumber = ? "
																	+ "WHERE ArtistID = ?");
			
			UpdateStatement.setString(6, artist.getArtistID());
			UpdateStatement.setString(1, artist.getArtistName());
			UpdateStatement.setString(2, artist.getArtistAge());
			UpdateStatement.setString(3, artist.getArtistGender());
			UpdateStatement.setString(4, artist.getArtistAddress());
			UpdateStatement.setString(5, artist.getArtistContactNumber());
			
			UpdateStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//DELETING a row in the table
	public void Delete(String ArtistID) {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `artist` WHERE `ArtistID` = ?");
			
			DeleteStatement.setString(1, ArtistID);
			DeleteStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
