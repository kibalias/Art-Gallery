package exe;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUDStatements.SellerCRUD;
import value.SellerValues;

public class SellerTemplate {
	//checks if all columns are filled
		public static String rowCheck (SellerValues sellerVal) {
			int rowCheck = SellerCRUD.Insert(sellerVal);
				
			if(rowCheck > 0) {
				return "Successful. Database Updated.";
			} else {
				return "Failed to save changes. Try Again.";
			}		
		}
		
		////returns the list of values into the table
		public static void readData (DefaultTableModel table) {
			ArrayList <SellerValues> seller = SellerCRUD.Read();
			
			for (SellerValues sellerVal : seller) {
				Object list[] = {
						sellerVal.getSellerId(),
						sellerVal.getSellerName(),
						sellerVal.getSellerAge(),
						sellerVal.getSellerGender(),
						sellerVal.getSellerAddress(),
						sellerVal.getSellerCity(),
						sellerVal.getSellerState(),
						sellerVal.getSellerZIP(),
						sellerVal.getSellerContactNumber()
				};
			table.addRow(list);
			}
		}
}
