package controller;

import java.sql.SQLException;

public class ExceptionSQL extends Exception {

	private SQLException message;

	public ExceptionSQL(SQLException err) {
		super();
		this.message = err;
	}
		
	public String toString(){
		String mess;
		mess = "Erreur SQL de type: " + message;
		return mess;
	}
	
		
}
