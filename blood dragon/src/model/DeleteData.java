package model;

import java.sql.*;

import javax.swing.JOptionPane;

public class DeleteData {

	public static void effacerVeh(String nomVeh) {
		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String instructionSQL = "DELETE FROM Veh WHERE NomVeh = '" + nomVeh
					+ "'";

			int nbIns = stat.executeUpdate(instructionSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
