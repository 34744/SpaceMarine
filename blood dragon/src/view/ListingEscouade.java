package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import javax.swing.*;

public class ListingEscouade extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\listerEscouade.jpg";

	// variables
	private JComboBox comboEscouade;
	private JLabel labNomEscouade, labTypeEscouade, labNbMembre,
			labArmeEscouade, labEquipementSupp;
	private JLabel labNomSgt, labMainDroite, labMainGauche, labEquipementSgt;
	private JLabel labNomSgtBis, labMainDroiteBis, labEquipementSgtBis;
	private Image background;
	private JPanel panelEscouade, panelSgt;

	private Vector<model.Officier> vectOfficier;
	private Vector<model.Escouade> vectEscouade;

	private int numCombo;

	public ListingEscouade() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);
		// image de fond
		background = getToolkit().getImage(IMAGE);
		this.setLayout(null);

		panelEscouade = new JPanel();
		panelEscouade.setBounds(50, 35, 275, 300);
		panelEscouade.setLayout(new GridLayout(6, 1));
		panelEscouade.setOpaque(false);

		comboEscouade = new JComboBox();

		labNomEscouade = new JLabel();
		labNomEscouade.setHorizontalAlignment(SwingConstants.CENTER);

		labTypeEscouade = new JLabel();
		labTypeEscouade.setHorizontalAlignment(SwingConstants.CENTER);

		labNbMembre = new JLabel();
		labNbMembre.setHorizontalAlignment(SwingConstants.CENTER);

		labArmeEscouade = new JLabel();
		labArmeEscouade.setHorizontalAlignment(SwingConstants.CENTER);

		labEquipementSupp = new JLabel();
		labEquipementSupp.setHorizontalAlignment(SwingConstants.CENTER);

		panelEscouade.add(comboEscouade);
		panelEscouade.add(labNomEscouade);
		panelEscouade.add(labTypeEscouade);
		panelEscouade.add(labNbMembre);
		panelEscouade.add(labArmeEscouade);
		panelEscouade.add(labEquipementSupp);

		panelSgt = new JPanel();
		panelSgt.setBounds(700, 425, 200, 150);
		panelSgt.setLayout(new GridLayout(4, 1));
		panelSgt.setOpaque(false);

		labNomSgt = new JLabel();
		labNomSgt.setHorizontalAlignment(SwingConstants.CENTER);

		labMainDroite = new JLabel();
		labMainDroite.setHorizontalAlignment(SwingConstants.CENTER);

		labMainGauche = new JLabel();
		labMainGauche.setHorizontalAlignment(SwingConstants.CENTER);

		labEquipementSgt = new JLabel();
		labEquipementSgt.setHorizontalAlignment(SwingConstants.CENTER);

		panelSgt.add(labNomSgt);
		panelSgt.add(labMainDroite);
		panelSgt.add(labMainGauche);
		panelSgt.add(labEquipementSgt);

		this.add(panelEscouade);
		this.add(panelSgt);

		this.getVectEscouade();
		this.getVectOfficier();

		MonGestionnaire itemListener = new MonGestionnaire();
		comboEscouade.addItemListener(itemListener);

	}

	public void getVectEscouade() {
		vectEscouade = controller.GestionBD.getEscouade();
		for (int i = 0; i < this.vectEscouade.size(); i++) {
			comboEscouade.addItem(vectEscouade.get(i).getNomEscouade());
		}
	}

	public void getVectOfficier() {
		vectOfficier = controller.GestionBD.getOfficier();
	}

	public void setInfoEscouade() {
		labNomEscouade.setText("Nom de l'escouade :"
				+ vectEscouade.get(numCombo).getNomEscouade());
		labTypeEscouade.setText("Escouade "
				+ vectEscouade.get(numCombo).getTypeEscouade());
		labNbMembre.setText("Nombre de membre : "
				+ vectEscouade.get(numCombo).getNbMembre());
		labArmeEscouade.setText("Arme de l'escouade : "
				+ vectEscouade.get(numCombo).getArmePrincipale());
		labEquipementSupp.setText("Equipement : "
				+ vectEscouade.get(numCombo).getEquipementSupp());
	}

	public void setInfoOfficier() {
		int i;

		for (i = 0; i < vectOfficier.size(); i++) {
			if ((vectOfficier.get(i).getNomOfficier().equals(
					vectEscouade.get(numCombo).getFKOfficier()) == true))
				break;
		}

		labNomSgt.setText("Sergent Vétérant : "
				+ vectOfficier.get(i).getNomOfficier());
		labMainDroite.setText("Arme : "
				+ vectOfficier.get(i).getMainDroiteOfficier());
		labMainGauche.setText(vectOfficier.get(i).getMainGaucheOfficier());
		labEquipementSgt.setText("Equipement : "
				+ vectOfficier.get(i).getEquipementOfficier());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background, 0, 0, this);

	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			// on recupère l'object
			numCombo = comboEscouade.getSelectedIndex();
			setInfoEscouade();
			setInfoOfficier();
		}
	}

}
