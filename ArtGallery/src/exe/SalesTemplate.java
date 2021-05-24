package exe;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import CRUDStatements.SalesCRUD;

import value.SalesValues;

public class SalesTemplate {
	//checks if all columns are filled
		public static String rowCheck (SalesValues salesVal) {
			int rowCheck = SalesCRUD.Insert(salesVal);
					
			if(rowCheck > 0) {
				return "Successful. Database Updated.";
			} else {
				return "Failed to save changes. Try Again.";
			}		
		}
			
		//returns the list of values into the table
		public static void readData (DefaultTableModel table) {
			ArrayList <SalesValues> sales = SalesCRUD.Read();
				
			for (SalesValues salesVal : sales) {
				Object list[] = {
						salesVal.getId(),
						salesVal.getBuyerId(),
						salesVal.getSellerId(),
						salesVal.getArtCode(),
						salesVal.getAmount(),
						salesVal.getDateOfSale()
				};
			table.addRow(list);
			}
		}
}
