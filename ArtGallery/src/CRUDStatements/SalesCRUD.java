package CRUDStatements;

import connection.DBConnection;
import value.SalesValues;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class SalesCRUD {
		
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
		public static ArrayList <SalesValues> Read() {
			
			ArrayList<SalesValues> salesList = new ArrayList<SalesValues>();
			
			try {
				conn =   DBConnection.getConnection();
				PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM sales ORDER BY DateOfSale");  
				ResultSetObject = SelectStatement.executeQuery();
				
				while(ResultSetObject.next()) {
					SalesValues sales = new SalesValues();
					sales.setId(ResultSetObject.getInt(1));
					sales.setBuyerId(ResultSetObject.getString(2));
					sales.setSellerId(ResultSetObject.getString(3));
					sales.setArtCode(ResultSetObject.getString(4));
					sales.setAmount(ResultSetObject.getFloat(5));
					sales.setDateOfSale(ResultSetObject.getDate(6));
					
					salesList.add(sales);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return salesList;
		}
		
	//INSERTING another row in the table
		public static int Insert(SalesValues sales) {
			conn = DBConnection.getConnection();
			int tableFill = 0;
			
			try {
				InsStatement = conn.prepareStatement("INSERT into sales VALUES (null, ?, ?, ?, ?, ?)");
				
				InsStatement.setString(1, sales.getBuyerId());
				InsStatement.setString(2, sales.getSellerId());
				InsStatement.setString(3, sales.getArtCode());
				InsStatement.setFloat(4, sales.getAmount());
				InsStatement.setDate(5, sales.getDateOfSale());
				
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
	//Retrieve SELLER ID for Combo Box
			public static void SellerIDComboBox(JComboBox combobox) {
				conn =   DBConnection.getConnection();
				try{
					PreparedStatement SelectStatement = conn.prepareStatement("SELECT * FROM seller");  
					ResultSetObject = SelectStatement.executeQuery();
					while(ResultSetObject.next()) {
						String seller_id = ResultSetObject.getString("SellerID");
						combobox.addItem(seller_id);
					}
						
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
}
		
