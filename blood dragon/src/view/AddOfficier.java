package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ExceptionSQL;

public class AddOfficier extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\ajoutOfficier.jpg";

	// variables
	private Image background;
	private JComboBox comboOfficier, comboMainDroite, comboMainGauche,
			comboEquipement;
	private JLabel labelOfficier, labelEquipement;
	private JTextField textFNomOfficier;
	private JButton butEncoder;
	private String nomOfficier, typeOfficier, mainGauche, mainDroite,
			Equipement;

	private Vector<model.Officier> vectOfficier;

	public AddOfficier() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);
		vectOfficier = new Vector<model.Officier>();
		// vectOfficier = controller.GestionBD.getOfficier();

		butEncoder = new JButton("Next");
		butEncoder.setBounds(900, 600, 100, 24);

		// JComboBox
		comboOfficier = new JComboBox();
		comboOfficier.addItem("Capitaine");
		comboOfficier.addItem("Chapelain");
		comboOfficier.addItem("Archiviste");
		comboOfficier.setBounds(50, 45, 100, 24);

		comboMainGauche = new JComboBox();
		comboMainGauche.addItem("Pistolet Bolter");
		comboMainGauche.addItem("Pistolet à plasma");
		comboMainGauche.setBounds(575, 300, 125, 24);

		comboMainDroite = new JComboBox();
		comboMainDroite.addItem("Arme de corps à corps");
		comboMainDroite.addItem("Arme énergétique");
		comboMainDroite.addItem("Gantelet énergétique");
		comboMainDroite.setBounds(300, 300, 175, 24);

		comboEquipement = new JComboBox();
		comboEquipement.addItem("Aucun");
		comboEquipement.addItem("Réacteur dorseaux");
		comboEquipement.setBounds(400, 530, 150, 24);
		// comboEquipement.setEditable(false);

		// JLTextField et JLabel
		labelOfficier = new JLabel("Nom du personnage: ");
		labelOfficier.setBounds(250, 45, 150, 24);
		textFNomOfficier = new JTextField();
		textFNomOfficier.setBounds(400, 45, 200, 24);

		labelEquipement = new JLabel("Equipement suppémentaire");
		labelEquipement.setBounds(400, 500, 175, 24);

		// image de fond
		background = getToolkit().getImage(IMAGE);

		this.setLayout(null);

		this.add(comboOfficier);
		this.add(labelOfficier);
		this.add(textFNomOfficier);
		this.add(comboEquipement);
		this.add(labelEquipement);
		this.add(comboMainGauche);
		this.add(comboMainDroite);
		this.add(butEncoder);

		MyButtonListener list = new MyButtonListener();
		butEncoder.addActionListener(list);

		this.setVisible(true);
	}

	public boolean ajouterOfficier() {

		nomOfficier = textFNomOfficier.getText();

		typeOfficier = String.valueOf(comboOfficier.getItemAt(comboOfficier
				.getSelectedIndex()));

		mainGauche = String.valueOf(comboMainGauche.getItemAt(comboMainGauche
				.getSelectedIndex()));

		mainDroite = String.valueOf(comboMainDroite.getItemAt(comboMainDroite
				.getSelectedIndex()));

		Equipement = String.valueOf(comboEquipement.getItemAt(comboEquipement
				.getSelectedIndex()));

		return true;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == butEncoder) {
				if (ajouterOfficier() == true) {

					model.Officier newB = new model.Officier(nomOfficier,
							typeOfficier, mainDroite, mainGauche, Equipement);
					switch (JOptionPane
							.showConfirmDialog(
									null,
									newB
											+ "\n\nEtes-vous sur de vouloir procéder à la mise à jour?",
									"RESUME", JOptionPane.INFORMATION_MESSAGE)) {

					case JOptionPane.YES_OPTION:
						try {
							controller.GestionBD.addOfficier(newB);
						} catch (ExceptionSQL e1) {
							JOptionPane.showMessageDialog(null, e1,
									"Erreur Type", JOptionPane.ERROR_MESSAGE);
						}

						break;

					case JOptionPane.NO_OPTION:
						JOptionPane.showMessageDialog(null,
								"Abandon de l'operation");
						break;
					}
				}
			}

		}
	}

}
