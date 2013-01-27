package model; 

import java.sql.*;

import javax.swing.JOptionPane;

import controller.ExceptionSQL;

public class AddDataOfficier {

	public static void ajoutOfficier(model.Officier o) throws controller.ExceptionSQL{
		
		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();
			String instructionSQL = "INSERT INTO Officier " + "(NomOfficier,"
			+ "TypeOfficier," + "MainDroiteOfficier,"
			+ "MainGaucheOfficier," + "EquipementOfficier) "
			+ " VALUES (" + "'" + o.getNomOfficier() + "'," + "'" + o.getTypeOfficier()
			+ "'," + "'" + o.getMainDroiteOfficier() + "'," + "'" + o.getMainGaucheOfficier();
			
			if (o.getEquipementOfficier().equals("Aucun")==true)
			   {
				   o.setEquipementOfficier(null);
				   instructionSQL+= "', " + "'" + o.getEquipementOfficier() + "'" + ")";
			   }
			   else
				   instructionSQL+= "', "  + "'" + o.getEquipementOfficier() + "'" + ")";
			
			int nbIns = stat.executeUpdate(instructionSQL);
		}
		catch (SQLException aDO){
			//JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
			throw new controller.ExceptionSQL(aDO);
		}
	}
}