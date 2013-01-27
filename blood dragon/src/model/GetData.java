package model;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GetData {

	public static Vector<model.Vehicule> getVehicule() {
		Vector<model.Vehicule> v = new Vector<model.Vehicule>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String requeteSQL = "SELECT NomVehicule, TypeVehicule, Avant, Flanc, Arriere,"
					+ "CC, CT, Force, Initiative, Attaque, NbPassagerMax FROM Vehicule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.add(new Vehicule(donnees.getString("NomVehicule"), donnees
						.getString("TypeVehicule"), donnees.getInt("Avant"),
						donnees.getInt("Flanc"), donnees.getInt("Arriere"),
						donnees.getInt("CC"), donnees.getInt("CT"), donnees
								.getInt("Force"), donnees.getInt("Initiative"),
						donnees.getInt("Attaque"), donnees
								.getInt("NbPassagerMax")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERRREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<model.Veh> getVeh() {
		Vector<model.Veh> v = new Vector<model.Veh>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String requeteSQL = "SELECT NomVeh, ArmePrincipaleVeh, ArmeSecondaireVeh, FKVehicule FROM Veh";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.add(new Veh(donnees.getString("NomVeh"), donnees
						.getString("ArmePrincipaleVeh"), donnees
						.getString("ArmeSecondaireVeh"), donnees
						.getString("FKVehicule")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<model.Veh> getVehiculeVeh(String nomVehicule) {

		Vector<model.Veh> v = new Vector<model.Veh>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String requeteSQL = "SELECT Veh.NomVeh, Veh.ArmePrincipaleVeh, Veh.ArmeSecondaireVeh, Veh.FKVehicule "
					+ "FROM Veh, Vehicule WHERE Veh.FKVehicule = Vehicule.NomVehicule";
			if (nomVehicule.equals("Tous") == false)
				requeteSQL += " AND Vehicule.NomVehicule  = '" + nomVehicule
						+ "'";

			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.add(new Veh(donnees.getString("NomVeh"), donnees
						.getString("ArmePrincipaleVeh"), donnees
						.getString("ArmeSecondaireVeh"), donnees
						.getString("FKVehicule")));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Escouade> getEscouade() {
		Vector<model.Escouade> v = new Vector<model.Escouade>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String requeteSQL = "SELECT NomEscouade, TypeEscouade, ArmePrincipale, NbMembre, EquipementSupp, FKOfficier FROM Escouade";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.add(new Escouade(donnees.getString("NomEscouade"), donnees
						.getString("TypeEscouade"), donnees
						.getString("ArmePrincipale"), donnees
						.getInt("NbMembre"), donnees
						.getString("EquipementSupp"), donnees
						.getString("FKOfficier")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Officier> getOfficier() {
		Vector<model.Officier> v = new Vector<model.Officier>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();

			String requeteSQL = "SELECT NomOfficier, TypeOfficier, MainDroiteOfficier, MainGaucheOfficier, EquipementOfficier FROM Officier";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();

			while (donnees.next()) {
				v.add(new Officier(donnees.getString("NomOfficier"), donnees
						.getString("TypeOfficier"), donnees
						.getString("MainDroiteOfficier"), donnees
						.getString("MainGaucheOfficier"), donnees
						.getString("EquipementOfficier")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<Arme> getArme() {
		Vector<model.Arme> v = new Vector<model.Arme>();

		try {
			Statement stat = controller.GestionBD.ouvrirBD().createStatement();
			String requeteSQL = "SELECT IdArme, Portee, Force, PenetrationArmure, Type FROM Arme";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				v.add(new Arme(donnees.getString("IdArme"), donnees
						.getInt("Portee"), donnees
						.getInt("Force"), donnees
						.getString("PenetrationArmure"), donnees
						.getString("Type")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
}
