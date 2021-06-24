package CRUDStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import value.SalesValues;

public class LogsCRUD {
	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
	static String buyer_name;
	static String seller_name;
	static String art_title;

//get by Transaction ID
	public SalesValues saleVal (String transId){
		SalesValues sales = new SalesValues();
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM sales WHERE id = '" + transId +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			
			if(ResultSetObject.next()) {
				sales.setId(ResultSetObject.getInt(1));
				sales.setBuyerId(ResultSetObject.getString(2));
				sales.setSellerId(ResultSetObject.getString(3));
				sales.setArtCode(ResultSetObject.getString(4));
				sales.setAmount(ResultSetObject.getFloat(5));
				sales.setDateOfSale(ResultSetObject.getDate(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sales;
	}
	
	public static String getBuyer(String BuyerId) {
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT BuyerName"
																	+ " FROM buyer"
																	+ " WHERE BuyerID = '" + BuyerId +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			if(ResultSetObject.next()) {
			buyer_name = ResultSetObject.getString("BuyerName");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return buyer_name;
	}
	
	public static String getSeller(String SellerId) {
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT SellerName"
																	+ " FROM seller"
																	+ " WHERE SellerID = '" + SellerId +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			if(ResultSetObject.next()) {
			seller_name = ResultSetObject.getString("SellerName");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return seller_name;
	}
	
	public static String getArtwork(String ArtCode) {
		conn =   DBConnection.getConnection();
		try {
			PreparedStatement SlctByStatement = conn.prepareStatement("SELECT ArtTitle"
																	+ " FROM artworks"
																	+ " WHERE ArtCode = '" + ArtCode +"'");  
			ResultSetObject = SlctByStatement.executeQuery();
			if(ResultSetObject.next()) {
			art_title = ResultSetObject.getString("ArtTitle");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return art_title;
	}
}
