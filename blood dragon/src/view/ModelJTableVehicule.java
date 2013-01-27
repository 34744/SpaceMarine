package view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModelJTableVehicule extends AbstractTableModel {

	Vector<String> columnNames = new Vector<String>();
	Vector<model.Veh> contents = new Vector<model.Veh>();

	public ModelJTableVehicule(Vector<model.Veh> contents) {
		setColumnNames();
		setContents(contents);
	}

	public void setColumnNames() {
		columnNames.addElement("Nom");
		columnNames.addElement("Armement Primaire");
		columnNames.addElement("Armement Secondaire");
		columnNames.addElement("Type");
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		return contents.size();
	}

	public String getColumnName(int col) {
		return columnNames.elementAt(col);
	}

	public Object getValueAt(int row, int col) {
		model.Veh v = contents.elementAt(row);
		switch (col) {
		case 0:
			return v.getNomVeh();
		case 1:
			return v.getArmePrincipaleVeh();
		case 2:
			return v.getArmeSecondaireVeh();
		case 3:
			return v.getFkVehicule();
		}
		return v;
	}

	public model.Veh getVehiculeAt(int row) {
		model.Veh v = contents.elementAt(row);
		return v;
	}

	public void setContents(Vector<model.Veh> contents) {
		this.contents = contents;
	}

}
