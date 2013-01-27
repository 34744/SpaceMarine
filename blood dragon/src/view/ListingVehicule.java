package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.*;

public class ListingVehicule extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\listerVehicule.jpg";

	// variables
	private Image background;
	private JTable tableVehicule;
	private ModelJTableVehicule modelVehicule;
	private JComboBox comboVeh;

	private JScrollPane JSP;

	private Vector<model.Vehicule> vectVehicule;
	private Vector<model.Veh> vectVeh;

	public ListingVehicule() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);

		// image de fond
		background = getToolkit().getImage(IMAGE);
		this.setLayout(null);

		vectVeh = new Vector<model.Veh>();
		vectVeh = controller.GestionBD.getVeh();

		vectVehicule = new Vector<model.Vehicule>();
		vectVehicule = controller.GestionBD.getVehicule();

		comboVeh = new JComboBox();
		comboVeh.setBounds(50, 50, 150, 24);
		comboVeh.addItem("Tous");

		for (int i = 0; i < vectVehicule.size(); i++) {
			comboVeh.addItem(vectVehicule.get(i).getNomVehicule());
		}

		MonGestionnaire monGestionnaire = new MonGestionnaire();
		comboVeh.addItemListener(monGestionnaire);

		modelVehicule = new ModelJTableVehicule(vectVeh);

		tableVehicule = new JTable(modelVehicule);
		tableVehicule.setAutoscrolls(true);
		tableVehicule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JSP = new JScrollPane(tableVehicule);
		JSP.setBounds(25, 100, 974, 400);

		this.add(JSP);
		this.add(comboVeh);
		this.setVisible(true);

	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int index = comboVeh.getSelectedIndex();
			vectVeh = controller.GestionBD.getVehiculeVeh(String
					.valueOf(comboVeh.getItemAt(index)));
			modelVehicule.setContents(vectVeh);
			tableVehicule.repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
	}

}
