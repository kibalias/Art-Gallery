package exe;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import CRUDStatements.BuyerCartCRUD;

import value.BuyerCartValues;

public class BuyerCartTemplate {
	//checks if all columns are filled
		public static String rowCheck (BuyerCartValues buyerCartVal) {
			int rowCheck = BuyerCartCRUD.Insert(buyerCartVal);
					
			if(rowCheck > 0) {
				return "Successful. Database Updated.";
			} else {
				return "Failed to save changes. Try Again.";
			}		
		}
			
		//returns the list of values into the table
		public static void readData (DefaultTableModel table) {
			ArrayList <BuyerCartValues> buyer_cart = BuyerCartCRUD.Read();
				
			for (BuyerCartValues buyerCartVal : buyer_cart) {
				Object list[] = {
						buyerCartVal.getId(),
						buyerCartVal.getArtCode(),
						buyerCartVal.getBuyerId(),
				};
			table.addRow(list);
			}
		}
}
