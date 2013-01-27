package model;

public class Arme {

	private String idArme;
	private int portee, force;
	private String penetration, type;
	public Arme(String idArme, int portee, int force, String penetration,
			String type) {
		super();
		this.idArme = idArme;
		this.portee = portee;
		this.force = force;
		this.penetration = penetration;
		this.type = type;
	}
	public String getIdArme() {
		return idArme;
	}
	public void setIdArme(String idArme) {
		this.idArme = idArme;
	}
	public int getPortee() {
		return portee;
	}
	public void setPortee(int portee) {
		this.portee = portee;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public String getPenetration() {
		return penetration;
	}
	public void setPenetration(String penetration) {
		this.penetration = penetration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		String message;

		message = "L'arme " + idArme + " a une portée de " + portee + " pas et est de type " + type;

		return message;
	}
}
