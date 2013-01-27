package view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModelJTableArme extends AbstractTableModel {

	Vector<String> columnNames = new Vector<String>();
	Vector<model.Arme> contents = new Vector<model.Arme>();

	public ModelJTableArme(Vector<model.Arme> contents) {
		setColumnNames();
		setContents(contents);
	}

	public void setColumnNames() {
		columnNames.addElement("Nom");
		columnNames.addElement("Port�e");
		columnNames.addElement("Force");
		columnNames.addElement("P�n�tration d'armure");
		columnNames.addElement("type");
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
		model.Arme a = contents.elementAt(row);
		switch (col) {
		case 0:
			return a.getIdArme();
		case 1:
			return a.getPortee();
		case 2:
			return a.getForce();
		case 3:
			return a.getPenetration();
		case 4:
			return a.getType();
		}
		return a;
	}

	public model.Arme getArmeeAt(int row) {
		model.Arme a = contents.elementAt(row);
		return a;
	}

	public void setContents(Vector<model.Arme> contents) {
		this.contents = contents;
	}

}
