package model;

public class Vehicule {

	private String nomVehicule, typeVehicule;
	private int avant, flanc, arriere, cc, ct, force, initiative, attaque,
			nbPassagerMax;

	public Vehicule(String nomVehicule, String typeVehicule, int avant,
			int flanc, int arriere, int cc, int ct, int force, int initiative,
			int attaque, int nbPassagerMax) {
		super();
		this.nomVehicule = nomVehicule;
		this.typeVehicule = typeVehicule;
		this.avant = avant;
		this.flanc = flanc;
		this.arriere = arriere;
		this.cc = cc;
		this.ct = ct;
		this.force = force;
		this.initiative = initiative;
		this.attaque = attaque;
		this.nbPassagerMax = nbPassagerMax;
	}

	public String getNomVehicule() {
		return nomVehicule;
	}

	public void setNomVehicule(String nomVehicule) {
		this.nomVehicule = nomVehicule;
	}

	public String getTypeVehicule() {
		return typeVehicule;
	}

	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	public int getAvant() {
		return avant;
	}

	public void setAvant(int avant) {
		this.avant = avant;
	}

	public int getFlanc() {
		return flanc;
	}

	public void setFlanc(int flanc) {
		this.flanc = flanc;
	}

	public int getArriere() {
		return arriere;
	}

	public void setArriere(int arriere) {
		this.arriere = arriere;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getNbPassagerMax() {
		return nbPassagerMax;
	}

	public void setNbPassagerMax(int nbPassagerMax) {
		this.nbPassagerMax = nbPassagerMax;
	}

}
