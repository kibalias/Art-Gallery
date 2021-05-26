package CRUDStatements;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import value.BuyerValues;


public class BuyerCRUD {
	
	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
/*
  					buyer_id,
					buyer_name,
					buyer_age,
					buyer_gender,
					buyer_address,
					buyer_city,
					buyer_state,
					buyer_zip,
					buyer_contactnum;
 */
	//getByArtCode
		public BuyerValues buyerVal (String BuyerId){
			BuyerValues buyer = new BuyerValues();
			conn =   DBConnection.getConnection();
			try {
				PreparedStatement SlctByStatement = conn.prepareStatement("SELECT * FROM buyer WHERE BuyerID = '" + BuyerId +"'");  
				ResultSetObject = SlctByStatement.executeQuery();
				
				if(ResultSetObject.next()) {
					buyer.setBuyerId(ResultSetObject.getString("BuyerID"));
					buyer.setBuyerName(ResultSetObject.getString("BuyerName"));
					buyer.setBuyerAge(ResultSetObject.getInt("BuyerAge"));
					buyer.setBuyerGender(ResultSetObject.getString("BuyerGender"));
					buyer.setBuyerAddress(ResultSetObject.getString("BuyerAddress"));
					buyer.setBuyerCity(ResultSetObject.getString("BuyerCity"));
					buyer.setBuyerState(ResultSetObject.getString("BuyerState"));
					buyer.setBuyerZIP(ResultSetObject.getString("BuyerZIP"));
					buyer.setBuyerContactNumber(ResultSetObject.getString("BuyerContactNumber"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return buyer;
		}
		
	//READING 
		public static ArrayList <BuyerValues> Read() {

			ArrayList<BuyerValues> buyerList = new ArrayList<BuyerValues>();
			
			try {
				conn =   DBConnection.getConnection();
				PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM buyer");  
				ResultSetObject = SelectStatement.executeQuery();
				
				while(ResultSetObject.next()) {
					BuyerValues buyer = new BuyerValues();
					
					buyer.setBuyerId(ResultSetObject.getString("BuyerID"));
					buyer.setBuyerName(ResultSetObject.getString("BuyerName"));
					buyer.setBuyerAge(ResultSetObject.getInt("BuyerAge"));
					buyer.setBuyerGender(ResultSetObject.getString("BuyerGender"));
					buyer.setBuyerAddress(ResultSetObject.getString("BuyerAddress"));
					buyer.setBuyerCity(ResultSetObject.getString("BuyerCity"));
					buyer.setBuyerState(ResultSetObject.getString("BuyerState"));
					buyer.setBuyerZIP(ResultSetObject.getString("BuyerZIP"));
					buyer.setBuyerContactNumber(ResultSetObject.getString("BuyerContactNumber"));
					
					buyerList.add(buyer);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return buyerList;
		}
		
		
		//INSERTING another row in the table
		public static int Insert(BuyerValues buyer) {
			conn = DBConnection.getConnection();
			int tableFill = 0;
			
			try {
				InsStatement = conn.prepareStatement("INSERT into buyer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				InsStatement.setString(1, buyer.getBuyerId());
				InsStatement.setString(2, buyer.getBuyerName());
				InsStatement.setInt(3, buyer.getBuyerAge());
				InsStatement.setString(4, buyer.getBuyerGender());
				InsStatement.setString(5, buyer.getBuyerAddress());
				InsStatement.setString(6, buyer.getBuyerCity());
				InsStatement.setString(7, buyer.getBuyerState());
				InsStatement.setString(8, buyer.getBuyerZIP());
				InsStatement.setString(9, buyer.getBuyerContactNumber());
				
				tableFill = InsStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return tableFill;
		}
		
		//UPDATING data 
		public static void Update(BuyerValues buyer) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE `buyer` SET BuyerName = ?, BuyerAge = ?, BuyerGender = ?, "
																		+ "BuyerAddress = ?, BuyerCity = ?, BuyerState = ?, BuyerZIP = ?, "
																		+ "BuyerContactNumber = ? WHERE `BuyerID` = ?");
				
				UpdateStatement.setString(9, buyer.getBuyerId());
				UpdateStatement.setString(1, buyer.getBuyerName());
				UpdateStatement.setInt(2, buyer.getBuyerAge());
				UpdateStatement.setString(3, buyer.getBuyerGender());
				UpdateStatement.setString(4, buyer.getBuyerAddress());
				UpdateStatement.setString(5, buyer.getBuyerCity());
				UpdateStatement.setString(6, buyer.getBuyerState());
				UpdateStatement.setString(7, buyer.getBuyerZIP());
				UpdateStatement.setString(8, buyer.getBuyerContactNumber());
				
				UpdateStatement.execute();
				
				JOptionPane.showMessageDialog(null, "Saved changes.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Changes cannot be saved. Try again.");
			}
		}
		
		//Deleting a row in the table
		public void Delete(String BuyerId) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `buyer` WHERE `BuyerID` = ?");
				
				DeleteStatement.setString(1, BuyerId);
				DeleteStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
