package CRUDStatements;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

import value.ArtworksValues;

public class ArtworksCRUD {

	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
	/*
	  				art_code,
					art_title,
					art_style,
					year_of_making,
					artist,
					art_status;
					art_price;
	 */
	
//getByArtCode
	public ArtworksValues artVal (String ArtCode){
		ArtworksValues artworks = new ArtworksValues();
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM artworks WHERE ArtCode = '" + ArtCode +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			
			if(ResultSetObject.next()) {
				artworks.setArtCode(ResultSetObject.getString("ArtCode"));
				artworks.setArtTitle(ResultSetObject.getString("ArtTitle"));
				artworks.setArtStyle(ResultSetObject.getString("ArtStyle"));
				artworks.setYearOfMaking(ResultSetObject.getString("YearOfMaking"));
				artworks.setArtist(ResultSetObject.getString("Artist"));
				artworks.setArtPrice(ResultSetObject.getFloat("ArtPrice"));
				artworks.setArtStatus(ResultSetObject.getString("ArtStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artworks;
	}
//getByArtTitle	
	public ArtworksValues getArtbyTitle (String ArtTitle){
		ArtworksValues artworks = new ArtworksValues();
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM artworks WHERE ArtTitle = '" + ArtTitle +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			
			if(ResultSetObject.next()) {
				artworks.setArtTitle(ResultSetObject.getString("ArtTitle"));
				artworks.setArtStyle(ResultSetObject.getString("ArtStyle"));
				artworks.setYearOfMaking(ResultSetObject.getString("YearOfMaking"));
				artworks.setArtist(ResultSetObject.getString("Artist"));
				artworks.setArtPrice(ResultSetObject.getFloat("ArtPrice"));
				artworks.setArtStatus(ResultSetObject.getString("ArtStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artworks;
	}
	
//READING 
	public static ArrayList <ArtworksValues> Read() {

		ArrayList<ArtworksValues> artList = new ArrayList<ArtworksValues>();
		
		try {
			conn =   DBConnection.getConnection();
			PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM artworks");  
			ResultSetObject = SelectStatement.executeQuery();
			
			while(ResultSetObject.next()) {
				ArtworksValues artworks = new ArtworksValues();
				artworks.setArtCode(ResultSetObject.getString("ArtCode"));
				artworks.setArtTitle(ResultSetObject.getString("ArtTitle"));
				artworks.setArtStyle(ResultSetObject.getString("ArtStyle"));
				artworks.setYearOfMaking(ResultSetObject.getString("YearOfMaking"));
				artworks.setArtist(ResultSetObject.getString("Artist"));
				artworks.setArtPrice(ResultSetObject.getFloat("ArtPrice"));
				artworks.setArtStatus(ResultSetObject.getString("ArtStatus"));
				
				artList.add(artworks);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return artList;
	}
	
	
	//INSERTING another row in the table
	public static int Insert(ArtworksValues artwork) {
		conn = DBConnection.getConnection();
		int tableFill = 0;
		
		try {
			InsStatement = conn.prepareStatement("INSERT into artworks VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			InsStatement.setString(1, artwork.getArtCode());
			InsStatement.setString(2, artwork.getArtTitle());
			InsStatement.setString(3, artwork.getArtStyle());
			InsStatement.setString(4, artwork.getYearOfMaking());
			InsStatement.setString(5, artwork.getArtist());
			InsStatement.setFloat(6, artwork.getArtPrice());
			InsStatement.setString(7, artwork.getArtStatus());
			
			tableFill = InsStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tableFill;
	}
	
	//UPDATING data 
	public static void Update(ArtworksValues artwork) {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE artworks SET ArtTitle = ?, ArtStyle = ?, YearOfMaking = ?, Artist = ?, ArtPrice = ?, ArtStatus = ? WHERE ArtCode = ?");
			
			UpdateStatement.setString(7, artwork.getArtCode());
			UpdateStatement.setString(1, artwork.getArtTitle());
			UpdateStatement.setString(2, artwork.getArtStyle());
			UpdateStatement.setString(3, artwork.getYearOfMaking());
			UpdateStatement.setString(4, artwork.getArtist());
			UpdateStatement.setFloat(5, artwork.getArtPrice());
			UpdateStatement.setString(6, artwork.getArtStatus());
			
			UpdateStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Deleting a row
	public void Delete(String ArtCode) {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `artworks` WHERE `ArtCode` = ?");
			
			DeleteStatement.setString(1, ArtCode);
			DeleteStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
