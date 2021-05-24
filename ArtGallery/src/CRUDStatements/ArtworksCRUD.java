package CRUDStatements;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
					dimension,
					artist
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
				artworks.setDimension(ResultSetObject.getString("Dimension"));
				artworks.setArtist(ResultSetObject.getString("Artist"));
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
				artworks.setDimension(ResultSetObject.getString("Dimension"));
				artworks.setArtist(ResultSetObject.getString("Artist"));
				
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
			InsStatement = conn.prepareStatement("INSERT into artworks VALUES (?, ?, ?, ?, ?, ?)");
			
			InsStatement.setString(1, artwork.getArtCode());
			InsStatement.setString(2, artwork.getArtTitle());
			InsStatement.setString(3, artwork.getArtStyle());
			InsStatement.setString(4, artwork.getYearOfMaking());
			InsStatement.setString(5, artwork.getDimension());
			InsStatement.setString(6, artwork.getArtist());
			
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
			PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE artworks SET ArtTitle = ?, ArtStyle = ?, YearOfMaking = ?, "
																	+ "Dimension = ?, Artist = ? WHERE ArtCode = ?");
			
			UpdateStatement.setString(6, artwork.getArtCode());
			UpdateStatement.setString(1, artwork.getArtTitle());
			UpdateStatement.setString(2, artwork.getArtStyle());
			UpdateStatement.setString(3, artwork.getYearOfMaking());
			UpdateStatement.setString(4, artwork.getDimension());
			UpdateStatement.setString(5, artwork.getArtist());
			
			UpdateStatement.execute();
			
			JOptionPane.showMessageDialog(null, "Saved changes.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Changes cannot be saved. Try again.");
		}
	}
	
	//Deleting a row in the table
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
	
	public static ArrayList <ArtworksValues> Search(String ArtTitle) {
		
		ArrayList<ArtworksValues> artList = new ArrayList<ArtworksValues>();
		conn = DBConnection.getConnection();
		try {
			PreparedStatement stmtSearch = conn.prepareStatement("SELECT * FROM artworks WHERE ArtTitle = ? ");
			
				stmtSearch.setString(1, ArtTitle);
				ResultSet rs = stmtSearch.executeQuery();
				
				while(rs.next()) {
					ArtworksValues artworks = new ArtworksValues();
					artworks.setArtCode(rs.getString("ArtCode"));
					artworks.setArtTitle(rs.getString("ArtTitle"));
					artworks.setArtStyle(rs.getString("ArtStyle"));
					artworks.setYearOfMaking(rs.getString("YearOfMaking"));
					artworks.setDimension(rs.getString("Dimension"));
					artworks.setArtist(rs.getString("Artist"));
					
					artList.add(artworks);
				//	System.out.println("Query: Found "+ rs.getString("ArtCode"));
				}			
		}catch (SQLException e) {
				e.printStackTrace();
			}
		return artList;		
	}
}
