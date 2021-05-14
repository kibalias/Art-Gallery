package exe;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import value.ArtistValues;
import CRUDStatements.ArtistCRUD;

public class ArtistTemplate {

	//checks if all columns are filled
	public static String rowCheck (ArtistValues artistVal) {
		int rowCheck = ArtistCRUD.Insert(artistVal);
			
		if(rowCheck > 0) {
			return "Successful. Database Updated.";
		} else {
			return "Failed to save changes. Try Again.";
		}		
	}
	
	//returns the list of values into the table
	public static void readData (DefaultTableModel table) {
		ArrayList <ArtistValues> artist = ArtistCRUD.Read();
		
		for (ArtistValues artistVal : artist) {
			Object list[] = {
					artistVal.getArtistID(),
					artistVal.getArtistName(),
					artistVal.getArtistAge(),
					artistVal.getArtistGender(),
					artistVal.getArtistAddress(),
					artistVal.getArtistContactNumber(),
			};
		table.addRow(list);
		}
	}
}
