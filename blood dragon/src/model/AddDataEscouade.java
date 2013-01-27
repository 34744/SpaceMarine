package model; 

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AddDataEscouade {

	public static void ajoutEscouade(model.Escouade e) {

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String instructionSQL = "INSERT INTO Officier " + "(NomOfficier,"
					+ "TypeOfficier," + "MainDroiteOfficier,"
					+ "MainGaucheOfficier," + "EquipementOfficier) "
					+ " VALUES (" + "'" + e.getNomOfficier() + "'," + "'"
					+ e.getTypeOfficier() + "'," + "'"
					+ e.getMainDroiteOfficier() + "'," + "'"
					+ e.getMainGaucheOfficier();

			if (e.getEquipementOfficier().equals("Aucun") == true) {
				e.setEquipementOfficier(null);
				instructionSQL += "', " + "'" + e.getEquipementOfficier() + "'"
						+ ")";
			} else
				instructionSQL += "', " + "'" + e.getEquipementOfficier() + "'"
						+ ")";

			String instructionSQLBis = "INSERT INTO Escouade "
					+ "(NomEscouade,TypeEscouade,ArmePrincipale,"
					+ "NbMembre,EquipementSupp, FKOfficier) " + " VALUES ("
					+ "'" + e.getNomEscouade() + "'," + "'"
					+ e.getTypeEscouade() + "'," + "'" + e.getArmePrincipale()
					+ "'," + "" + e.getNbMembre();
			if (e.getEquipementSupp().equals("Aucun") == true) {
				e.setEquipementSupp(null);
				instructionSQLBis += ", " + "'" + e.getEquipementSupp() + "'";
			} else {
				instructionSQLBis += ", " + "'" + e.getEquipementSupp() + "'";
			}

			instructionSQLBis += ",'" + e.getFKOfficier() + "')";

			int nbIns = stat.executeUpdate(instructionSQL);
			int nbInsBis = stat.executeUpdate(instructionSQLBis);

		} catch (SQLException aDO) {
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void upEscouade(Escouade e, String upNomEscouade) {
		try {

			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String instructionSQL = "UPDATE  Officier SET "
					+ " MainDroiteOfficier = '" + e.getMainDroiteOfficier()
					+ "'," + "EquipementOfficier = '";

			if (e.getEquipementOfficier().equals("Aucun") == true) {
				e.setEquipementOfficier(null);
				instructionSQL += e.getEquipementOfficier() + "'";
			} else
				instructionSQL += e.getEquipementOfficier() + "'";

			instructionSQL += "WHERE NomOfficier = '" + e.getFKOfficier() + "'";

			int nbIns = stat.executeUpdate(instructionSQL);

			String instructionSQLBis = "UPDATE  Escouade SET "
					+ " TypeEscouade = '" + e.getTypeEscouade() + "',"
					+ "ArmePrincipale = '" + e.getArmePrincipale() + "',"
					+ "NbMembre = " + e.getNbMembre() + ","
					+ "EquipementSupp = '";
			if (e.getEquipementSupp().equals("Aucun") == true) {
				e.setEquipementSupp(null);
				instructionSQLBis += e.getEquipementSupp() + "'";
			} else
				instructionSQLBis += e.getEquipementSupp() + "'";

			instructionSQLBis += " WHERE NomEscouade = '" + upNomEscouade + "'";

			int nbInsBis = stat.executeUpdate(instructionSQLBis);

		} catch (SQLException sqlE) {
			JOptionPane.showMessageDialog(null, sqlE, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
