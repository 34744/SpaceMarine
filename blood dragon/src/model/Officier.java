package model;

public class Officier {

	private String nomOfficier, typeOfficier, mainDroiteOfficier,
			mainGaucheOfficier, equipementOfficier;

	public Officier(String nomOfficier, String typeOfficier,
			String mainDroiteOfficier, String mainGaucheOfficier,
			String equipementOfficier) {
		super();
		this.nomOfficier = nomOfficier;
		this.typeOfficier = typeOfficier;
		this.mainDroiteOfficier = mainDroiteOfficier;
		this.mainGaucheOfficier = mainGaucheOfficier;
		this.equipementOfficier = equipementOfficier;
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

		message = this.typeOfficier + " " + this.nomOfficier
				+ " est équipé d'une " + this.mainDroiteOfficier + " et d'un "
				+ this.mainGaucheOfficier;

		if (this.equipementOfficier.equals("Réacteur dorseaux")) {
			message += " et possède des " + this.equipementOfficier;
		}

		return message;
	}

}
