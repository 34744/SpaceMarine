package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListingArme extends JPanel{

	// variables
	private JTable tableArme;
	private ModelJTableArme modelArme;

	private JScrollPane JSP;

	private Vector<model.Arme> vectArme;


	public ListingArme() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);

		this.setLayout(null);

		vectArme = new Vector<model.Arme>();
		vectArme = controller.GestionBD.getArme();

		modelArme = new ModelJTableArme(vectArme);

		tableArme = new JTable(modelArme);
		tableArme.setAutoscrolls(true);
		tableArme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JSP = new JScrollPane(tableArme);
		JSP.setBounds(25, 100, 974, 400);

		this.add(JSP);
		this.setVisible(true);

	}

}
