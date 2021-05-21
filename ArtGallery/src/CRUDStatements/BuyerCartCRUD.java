package CRUDStatements;

import connection.DBConnection;
import value.BuyerCartValues;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class BuyerCartCRUD {
		
	static Connection conn = null;
	static PreparedStatement InsStatement = null;
	static ResultSet ResultSetObject = null;
	static Float amount;
		/* 
		 * 				id
		 				art_code
						buyer_id
						amount
		*/
	
	//READING	
		public static ArrayList <BuyerCartValues> Read() {
			
			ArrayList<BuyerCartValues> cartList = new ArrayList<BuyerCartValues>();
			
			try {
				conn =   DBConnection.getConnection();
				PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM sales");  
				ResultSetObject = SelectStatement.executeQuery();
				
				while(ResultSetObject.next()) {
					BuyerCartValues buyercart = new BuyerCartValues();
					buyercart.setId(ResultSetObject.getInt("id"));
					buyercart.setArtCode(ResultSetObject.getString("ArtCode"));
					buyercart.setBuyerId(ResultSetObject.getString("BuyerID"));
					buyercart.setPaymentStatus(ResultSetObject.getString("PaymentStatusCode"));
					
					cartList.add(buyercart);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return cartList;
		}
		
	//INSERTING another row in the table
		public static int Insert(BuyerCartValues cart) {
			conn = DBConnection.getConnection();
			int tableFill = 0;
			
			try {
				InsStatement = conn.prepareStatement("INSERT into prodcart VALUES (null, ?, ?, ?)");
				
				InsStatement.setString(1, cart.getArtCode());
				InsStatement.setString(2, cart.getBuyerId());
				InsStatement.setString(3, cart.getPaymentStatus());
				
				tableFill = InsStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tableFill;
		}
		
	//UPDATING data
		/*public static void Update(BuyerCartValues cart) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement UpdateStatement = conn.prepareStatement("UPDATE artist SET ArtistAge = ? WHERE ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	//DELETING a row in the table
		public void Delete(int id) {
			conn = DBConnection.getConnection();
			try {
				PreparedStatement DeleteStatement = conn.prepareStatement("DELETE FROM `sales` WHERE `id` = ?");
				
				DeleteStatement.setInt(1, id);
				DeleteStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
/*	//getAmount
		public static Float getAmount (String ArtCode) {
			conn =   DBConnection.getConnection();
		
			try {
				
				PreparedStatement SelectByArtCode = conn.prepareStatement("SELECT ArtPrice FROM artworks "
																			+ "WHERE ArtCode = '" + ArtCode +"'");  
				ResultSetObject = SelectByArtCode.executeQuery();
				while(ResultSetObject.next()) {
					amount = ResultSetObject.getFloat("ArtPrice");
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return amount;
		}
*/	
	//Retrieve ART CODE for Combo Box
		public static void ArtCodeComboBox(JComboBox combobox) {
			conn =   DBConnection.getConnection();
			try{
				PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM artworks");  
				ResultSetObject = SelectStatement.executeQuery();
				while(ResultSetObject.next()) {
					String ArtCode = ResultSetObject.getString("ArtCode");
					combobox.addItem(ArtCode);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	//Retrieve BUYER ID for Combo Box
			public static void BuyerIDComboBox(JComboBox combobox) {
				conn =   DBConnection.getConnection();
				try{
					PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM buyer");  
					ResultSetObject = SelectStatement.executeQuery();
					while(ResultSetObject.next()) {
						String buyer_id = ResultSetObject.getString("BuyerID");
						combobox.addItem(buyer_id);
					}
						
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
}
		
