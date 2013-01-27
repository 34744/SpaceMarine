package controller;

import java.sql.*;
import java.util.Vector;

import model.Arme;
import model.Escouade;

public class GestionBD {

	public static Connection ouvrirBD() {
		return model.AccessBD.GetInstance();
	}

	public static void fermerBD() {
		model.AccessBD.closeBD();
	}

	public static Vector<model.Officier> getOfficier() {
		return model.GetData.getOfficier();
	}

	public static Vector<model.Escouade> getEscouade() {
		return model.GetData.getEscouade();
	}

	public static void addOfficier(model.Officier o) throws ExceptionSQL {
		model.AddDataOfficier.ajoutOfficier(o);
	}

	public static void addEscouade(model.Escouade o) {
		model.AddDataEscouade.ajoutEscouade(o);
	}

	public static Vector<model.Veh> getVeh() {
		return model.GetData.getVeh();
	}

	public static Vector<model.Vehicule> getVehicule() {
		return model.GetData.getVehicule();
	}

	public static Vector<model.Veh> getVehiculeVeh(String nomVeh) {
		return model.GetData.getVehiculeVeh(nomVeh);
	}

	public static void updateEscouade(Escouade e, String nomEscouade) {
		model.AddDataEscouade.upEscouade(e, nomEscouade);

	}

	public static void effacerVeh(String nomVeh) {
		model.DeleteData.effacerVeh(nomVeh);

	}

	public static Vector<model.Arme> getArme() {
		return model.GetData.getArme();
	} 
}
