package model;

public class Veh {

	private String nomVeh, armePrincipaleVeh, armeSecondaireVeh, fkVehicule;

	public Veh(String nomVeh, String armePrincipaleVeh,
			String armeSecondaireVeh, String fkVehicule) {
		super();
		this.nomVeh = nomVeh;
		this.armePrincipaleVeh = armePrincipaleVeh;
		this.armeSecondaireVeh = armeSecondaireVeh;
		this.fkVehicule = fkVehicule;
	}

	public String getNomVeh() {
		return nomVeh;
	}

	public void setNomVeh(String nomVeh) {
		this.nomVeh = nomVeh;
	}

	public String getArmePrincipaleVeh() {
		return armePrincipaleVeh;
	}

	public void setArmePrincipaleVeh(String armePrincipaleVeh) {
		this.armePrincipaleVeh = armePrincipaleVeh;
	}

	public String getArmeSecondaireVeh() {
		return armeSecondaireVeh;
	}

	public void setArmeSecondaireVeh(String armeSecondaireVeh) {
		this.armeSecondaireVeh = armeSecondaireVeh;
	}

	public String getFkVehicule() {
		return fkVehicule;
	}

	public void setFkVehicule(String fkVehicule) {
		this.fkVehicule = fkVehicule;
	}
}
