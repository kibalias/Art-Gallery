package CRUDStatements;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

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
					buyer_affiliation,
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
					buyer.setBuyerAge(ResultSetObject.getString("BuyerAge"));
					buyer.setBuyerGender(ResultSetObject.getString("BuyerGender"));
					buyer.setBuyerAddress(ResultSetObject.getString("BuyerAddress"));
					buyer.setBuyerAffiliation(ResultSetObject.getString("BuyerAffiliation"));
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
					buyer.setBuyerAge(ResultSetObject.getString("BuyerAge"));
					buyer.setBuyerGender(ResultSetObject.getString("BuyerGender"));
					buyer.setBuyerAddress(ResultSetObject.getString("BuyerAddress"));
					buyer.setBuyerAffiliation(ResultSetObject.getString("BuyerAffiliation"));
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
				InsStatement = conn.prepareStatement("INSERT into buyer VALUES (?, ?, ?, ?, ?, ?, ?)");
				
				InsStatement.setString(1, buyer.getBuyerId());
				InsStatement.setString(2, buyer.getBuyerName());
				InsStatement.setString(3, buyer.getBuyerAge());
				InsStatement.setString(4, buyer.getBuyerGender());
				InsStatement.setString(5, buyer.getBuyerAddress());
				InsStatement.setString(6, buyer.getBuyerAffiliation());
				InsStatement.setString(7, buyer.getBuyerContactNumber());
				
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
				PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE `buyer` SET BuyerName = ?, BuyerAge = ?, BuyerGender = ?, BuyerAddress = ?, BuyerAffiliation = ?, BuyerContactNumber = ? WHERE `BuyerID` = ?");
				
				UpdateStatement.setString(7, buyer.getBuyerId());
				UpdateStatement.setString(1, buyer.getBuyerName());
				UpdateStatement.setString(2, buyer.getBuyerAge());
				UpdateStatement.setString(3, buyer.getBuyerGender());
				UpdateStatement.setString(4, buyer.getBuyerAddress());
				UpdateStatement.setString(5, buyer.getBuyerAffiliation());
				UpdateStatement.setString(6, buyer.getBuyerContactNumber());
				
				UpdateStatement.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
