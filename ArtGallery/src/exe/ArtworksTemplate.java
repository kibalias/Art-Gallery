package exe;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import value.ArtworksValues;
import CRUDStatements.ArtworksCRUD;

public class ArtworksTemplate {

	//checks if all columns are filled
	public static String rowCheck (ArtworksValues artVal) {
		int rowCheck = ArtworksCRUD.Insert(artVal);
			
		if(rowCheck > 0) {
			return "Successful. Database Updated.";
		} else {
			return "Failed to save changes. Try Again.";
		}		
	}
	
	////returns the list of values into the table
	public static void readData (DefaultTableModel table) {
		ArrayList <ArtworksValues> artworks = ArtworksCRUD.Read();
		
		for (ArtworksValues artVal : artworks) {
			Object list[] = {
					artVal.getArtCode(),
					artVal.getArtTitle(),
					artVal.getArtStyle(),
					artVal.getYearOfMaking(),
					artVal.getArtist(),
					artVal.getArtStatus(),
					artVal.getArtPrice(),
			};
		table.addRow(list);
		}
	}
}
