package CRUDStatements;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import value.SellerValues;


public class SellerCRUD {
	
	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
/*
  					seller_id,
					seller_name,
					seller_age,
					seller_gender,
					seller_address,
					seller_city,
					seller_state,
					seller_zip,
					seller_contactnum;
 */
	//getByArtCode
		public SellerValues sellerVal (String SellerId){
			SellerValues seller = new SellerValues();
			conn =   DBConnection.getConnection();
			try {
				PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM seller WHERE SellerID = '" + SellerId +"'");  
				ResultSetObject = SlctByStatement.executeQuery();
				
				if(ResultSetObject.next()) {
					seller.setSellerId(ResultSetObject.getString("SellerID"));
					seller.setSellerName(ResultSetObject.getString("SellerName"));
					seller.setSellerAge(ResultSetObject.getInt("SellerAge"));
					seller.setSellerGender(ResultSetObject.getString("SellerGender"));
					seller.setSellerAddress(ResultSetObject.getString("SellerAddress"));
					seller.setSellerCity(ResultSetObject.getString("SellerCity"));
					seller.setSellerState(ResultSetObject.getString("SellerState"));
					seller.setSellerZIP(ResultSetObject.getString("SellerZIP"));
					seller.setSellerContactNumber(ResultSetObject.getString("SellerContactNumber"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return seller;
		}
		
	//READING 
		public static ArrayList <SellerValues> Read() {

			ArrayList<SellerValues> sellerList = new ArrayList<SellerValues>();
			
			try {
				conn =   DBConnection.getConnection();
				PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM seller");  
				ResultSetObject = SelectStatement.executeQuery();
				
				while(ResultSetObject.next()) {
					SellerValues seller = new SellerValues();
					
					seller.setSellerId(ResultSetObject.getString("SellerID"));
					seller.setSellerName(ResultSetObject.getString("SellerName"));
					seller.setSellerAge(ResultSetObject.getInt("SellerAge"));
					seller.setSellerGender(ResultSetObject.getString("SellerGender"));
					seller.setSellerAddress(ResultSetObject.getString("SellerAddress"));
					seller.setSellerCity(ResultSetObject.getString("SellerCity"));
					seller.setSellerState(ResultSetObject.getString("SellerState"));
					seller.setSellerZIP(ResultSetObject.getString("SellerZIP"));
					seller.setSellerContactNumber(ResultSetObject.getString("SellerContactNumber"));
					
					sellerList.add(seller);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return sellerList;
		}
		
		
		//INSERTING another row in the table
		public static int Insert(SellerValues seller) {
			conn = DBConnection.getConnection();
			int tableFill = 0;
			
			try {
				InsStatement = conn.prepareStatement("INSERT into seller VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				InsStatement.setString(1, seller.getSellerId());
				InsStatement.setString(2, seller.getSellerName());
				InsStatement.setInt(3, seller.getSellerAge());
				InsStatement.setString(4, seller.getSellerGender());
				InsStatement.setString(5, seller.getSellerAddress());
				InsStatement.setString(6, seller.getSellerCity());
				InsStatement.setString(7, seller.getSellerState());
				InsStatement.setString(8, seller.getSellerZIP());
				InsStatement.setString(9, seller.getSellerContactNumber());
				
				tableFill = InsStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return tableFill;
		}
		
		//UPDATING data 
		public static void Update(SellerValues seller) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE `seller` SET SellerName = ?, SellerAge = ?, SellerGender = ?, "
																		+ "SellerAddress = ?, SellerCity = ?, SellerState = ?, SellerZIP = ?, "
																		+ "SellerContactNumber = ? WHERE `SellerID` = ?");
				
				UpdateStatement.setString(9, seller.getSellerId());
				UpdateStatement.setString(1, seller.getSellerName());
				UpdateStatement.setInt(2, seller.getSellerAge());
				UpdateStatement.setString(3, seller.getSellerGender());
				UpdateStatement.setString(4, seller.getSellerAddress());
				UpdateStatement.setString(5, seller.getSellerCity());
				UpdateStatement.setString(6, seller.getSellerState());
				UpdateStatement.setString(7, seller.getSellerZIP());
				UpdateStatement.setString(8, seller.getSellerContactNumber());
				
				UpdateStatement.execute();
				
				JOptionPane.showMessageDialog(null, "Saved changes.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Changes cannot be saved. Try again.");
			}
		}
		
		//Deleting a row in the table
		public void Delete(String SellerId) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `seller` WHERE `SellerID` = ?");
				
				DeleteStatement.setString(1, SellerId);
				DeleteStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
