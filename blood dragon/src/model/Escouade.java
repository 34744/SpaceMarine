package model;

public class Escouade {

	private String nomEscouade, typeEscouade, armePrincipale, equipementSupp,
			fKOfficier;
	private String nomOfficier, typeOfficier, mainDroiteOfficier,
			mainGaucheOfficier, equipementOfficier;
	private int nbMembre;

	public Escouade(String nomEscouade, String typeEscouade,
			String armePrincipale, int nbMembre, String equipementSupp,
			String officier) {
		super();
		this.nomEscouade = nomEscouade;
		this.typeEscouade = typeEscouade;
		this.armePrincipale = armePrincipale;
		this.nbMembre = nbMembre;
		this.equipementSupp = equipementSupp;
		fKOfficier = officier;

	}

	public Escouade(String nomEscouade, String typeEscouade,
			String armePrincipale, String equipementSupp, String officier,
			String nomOfficier, String typeOfficier, String mainDroiteOfficier,
			String mainGaucheOfficier, String equipementOfficier, int nbMembre) {
		super();
		this.nomEscouade = nomEscouade;
		this.typeEscouade = typeEscouade;
		this.armePrincipale = armePrincipale;
		this.equipementSupp = equipementSupp;
		fKOfficier = officier;
		this.nomOfficier = nomOfficier;
		this.typeOfficier = typeOfficier;
		this.mainDroiteOfficier = mainDroiteOfficier;
		this.mainGaucheOfficier = mainGaucheOfficier;
		this.equipementOfficier = equipementOfficier;
		this.nbMembre = nbMembre;
	}

	public String getNomEscouade() {
		return nomEscouade;
	}

	public void setNomEscouade(String nomEscouade) {
		this.nomEscouade = nomEscouade;
	}

	public String getTypeEscouade() {
		return typeEscouade;
	}

	public void setTypeEscouade(String typeEscouade) {
		this.typeEscouade = typeEscouade;
	}

	public String getArmePrincipale() {
		return armePrincipale;
	}

	public void setArmePrincipale(String armePrincipale) {
		this.armePrincipale = armePrincipale;
	}

	public String getEquipementSupp() {
		return equipementSupp;
	}

	public void setEquipementSupp(String equipementSupp) {
		this.equipementSupp = equipementSupp;
	}

	public String getFKOfficier() {
		return fKOfficier;
	}

	public void setFKOfficier(String officier) {
		fKOfficier = officier;
	}

	public int getNbMembre() {
		return nbMembre;
	}

	public void setNbMembre(int nbMembre) {
		this.nbMembre = nbMembre;
	}

	public String getNomOfficier() {
		return nomOfficier;
	}

	public void setNomOfficier(String nomOfficier) {
		this.nomOfficier = nomOfficier;
	}

	public String getTypeOfficier() {
		return typeOfficier;
	}

	public void setTypeOfficier(String typeOfficier) {
		this.typeOfficier = typeOfficier;
	}

	public String getMainDroiteOfficier() {
		return mainDroiteOfficier;
	}

	public void setMainDroiteOfficier(String mainDroiteOfficier) {
		this.mainDroiteOfficier = mainDroiteOfficier;
	}

	public String getMainGaucheOfficier() {
		return mainGaucheOfficier;
	}

	public void setMainGaucheOfficier(String mainGaucheOfficier) {
		this.mainGaucheOfficier = mainGaucheOfficier;
	}

	public String getEquipementOfficier() {
		return equipementOfficier;
	}

	public void setEquipementOfficier(String equipementOfficier) {
		this.equipementOfficier = equipementOfficier;
	}

	public String toString() {
		String message;

		message = "L'escouade " + typeEscouade + " " + nomEscouade
				+ " est équipé de " + armePrincipale;

		if (this.equipementSupp.equals("Réacteur dorseaux")) {
			message += ", possède des " + this.equipementSupp;
		}

		message += " et est dirigé par le sergent " + fKOfficier;

		return message;
	}
}
