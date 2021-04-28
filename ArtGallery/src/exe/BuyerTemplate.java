package exe;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUDStatements.BuyerCRUD;
import value.BuyerValues;

public class BuyerTemplate {
	//checks if all columns are filled
		public static String rowCheck (BuyerValues buyerVal) {
			int rowCheck = BuyerCRUD.Insert(buyerVal);
				
			if(rowCheck > 0) {
				return "Successful. Database Updated.";
			} else {
				return "Failed to save changes. Try Again.";
			}		
		}
		
		////returns the list of values into the table
		public static void readData (DefaultTableModel table) {
			ArrayList <BuyerValues> buyer = BuyerCRUD.Read();
			
			for (BuyerValues buyerVal : buyer) {
				Object list[] = {
						buyerVal.getBuyerId(),
						buyerVal.getBuyerName(),
						buyerVal.getBuyerAge(),
						buyerVal.getBuyerGender(),
						buyerVal.getBuyerAddress(),
						buyerVal.getBuyerAffiliation(),
						buyerVal.getBuyerContactNumber()
				};
			table.addRow(list);
			}
		}
}
