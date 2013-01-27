package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.*;

public class UpdateEscouade extends JPanel {
	// constantes
	private final static String IMAGE = ".\\image\\ajoutEscouade.jpg";
	// variables
	private Image background;
	private JComboBox comboEscouade, comboNomEscouade, comboSergent,
			comboNbMembre, comboEquipement, comboEscouadeArme;
	private JLabel labelEscouade, labelSergent, labelNbMembre, labelEquipement;
	private JTextField textFNomEscouade, textFNomSergent,
			textFSergentMainGauche;
	private JButton butEncoder;
	private int numCombo;
	private Vector<model.Escouade> vectEscouade;
	private Vector<model.Officier> vectSgt;

	public UpdateEscouade() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);

		butEncoder = new JButton("MAJ");
		butEncoder.setBounds(900, 600, 100, 24);

		// JComboBox
		comboNomEscouade = new JComboBox();
		comboNomEscouade.setBounds(10, 10, 100, 24);

		comboEscouade = new JComboBox();
		comboEscouade.addItem("Tactique");
		comboEscouade.addItem("Assaut");
		comboEscouade.addItem("Devastator");
		comboEscouade.addItem("Veterant");
		comboEscouade.setBounds(150, 10, 100, 24);

		comboNbMembre = new JComboBox();
		comboNbMembre.addItem("5");
		comboNbMembre.addItem("10");
		comboNbMembre.setBounds(225, 90, 50, 24);

		comboSergent = new JComboBox();
		comboSergent.addItem("Arme de corps à corps");
		comboSergent.addItem("Arme énergétique");
		comboSergent.addItem("Gantelet énergétique");
		comboSergent.setBounds(550, 350, 175, 24);

		comboEscouadeArme = new JComboBox();
		comboEscouadeArme.addItem("Bolter");
		comboEscouadeArme.addItem("Arme de corps à corps");
		comboEscouadeArme.setBounds(50, 350, 175, 24);

		comboEquipement = new JComboBox();
		comboEquipement.addItem("Aucun");
		comboEquipement.addItem("Réacteur dorseaux");
		comboEquipement.setBounds(450, 530, 150, 24);
		// comboEquipement.setEditable(false);

		// JLTextField et JLabel
		labelEscouade = new JLabel("Nom de l'escouade: ");
		labelEscouade.setBounds(10, 60, 150, 24);
		textFNomEscouade = new JTextField();
		textFNomEscouade.setBounds(160, 60, 200, 24);
		textFNomEscouade.setEditable(false);

		labelSergent = new JLabel("Nom du sergent: ");
		labelSergent.setBounds(550, 60, 150, 24);
		textFNomSergent = new JTextField();
		textFNomSergent.setBounds(680, 60, 200, 24);
		textFNomSergent.setEditable(false);

		textFSergentMainGauche = new JTextField("Pistolet bolter");
		textFSergentMainGauche.setEditable(false);
		textFSergentMainGauche.setBounds(875, 350, 100, 24);

		labelNbMembre = new JLabel("Nombre de membres de l'escouade: ");
		labelNbMembre.setBounds(10, 90, 300, 24);

		labelEquipement = new JLabel("Equipement suppémentaire");
		labelEquipement.setBounds(450, 500, 175, 24);

		// image de fond
		background = getToolkit().getImage(IMAGE);
		this.setLayout(null);
		this.add(comboEscouade);
		this.add(labelEscouade);
		this.add(textFNomEscouade);
		this.add(labelSergent);
		this.add(textFNomSergent);
		this.add(comboSergent);
		this.add(textFSergentMainGauche);
		this.add(comboNbMembre);
		this.add(labelNbMembre);
		this.add(comboEquipement);
		this.add(labelEquipement);
		this.add(comboEscouadeArme);
		this.add(butEncoder);
		this.add(comboNomEscouade);

		vectEscouade = new Vector<model.Escouade>();
		vectEscouade = controller.GestionBD.getEscouade();

		vectSgt = new Vector<model.Officier>();
		vectSgt = controller.GestionBD.getOfficier();

		for (int i = 0; i < vectEscouade.size(); i++) {
			comboNomEscouade.addItem(vectEscouade.get(i).getNomEscouade());
		}

		MyButtonListener list = new MyButtonListener();
		butEncoder.addActionListener(list);
		MonGestionnaire gestionItem = new MonGestionnaire();
		comboNomEscouade.addItemListener(gestionItem);

		this.setVisible(true);
	}

	public void majEscouade() {

		try {

			// on recupere l'escouade dans le vecteur Escouade
			// et on la met a jour grace au settor

			vectEscouade.get(numCombo).setEquipementSupp(
					String.valueOf(comboEquipement.getItemAt(comboEquipement
							.getSelectedIndex())));
			vectEscouade.get(numCombo).setTypeEscouade(
					String.valueOf(comboEscouade.getItemAt(comboEscouade
							.getSelectedIndex())));
			vectEscouade.get(numCombo).setNbMembre(
					Integer.parseInt(String.valueOf(comboNbMembre
							.getItemAt(comboNbMembre.getSelectedIndex()))));

			vectEscouade.get(numCombo).setNomEscouade(
					textFNomEscouade.getText());

			vectEscouade.get(numCombo).setArmePrincipale(
					String.valueOf(comboEscouadeArme
							.getItemAt(comboEscouadeArme.getSelectedIndex())));

			vectEscouade.get(numCombo)
					.setNomOfficier(textFNomSergent.getText());
			vectEscouade.get(numCombo).setMainGaucheOfficier(
					textFSergentMainGauche.getText());
			vectEscouade.get(numCombo).setEquipementOfficier(
					String.valueOf(comboEquipement.getItemAt(comboEquipement
							.getSelectedIndex())));
			vectEscouade.get(numCombo).setMainDroiteOfficier(
					String.valueOf(comboSergent.getItemAt(comboSergent
							.getSelectedIndex())));

			// on recupere l'escouade mise a jour
			model.Escouade e = vectEscouade.get(numCombo);

			switch (JOptionPane
					.showConfirmDialog(
							null,
							e
									+ "\n\nEtes-vous sur de vouloir procéder à la mise à jour?",
							"RESUME", JOptionPane.INFORMATION_MESSAGE)) {

			case JOptionPane.YES_OPTION:
				controller.GestionBD.updateEscouade(e, vectEscouade.get(
						numCombo).getNomEscouade());

				break;

			case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(null, "Abandon de l'operation");
				break;

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background, 0, 0, this);
	}

	private class MonGestionnaire implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			// on recupère l'object
			numCombo = comboNomEscouade.getSelectedIndex();

			// on met a jour les JTextFiled et JComboBox

			textFNomEscouade.setText(vectEscouade.get(numCombo)
					.getNomEscouade());

			comboNbMembre.setSelectedItem(String.valueOf(vectEscouade.get(
					numCombo).getNbMembre()));
			comboEscouade.setSelectedItem(vectEscouade.get(numCombo)
					.getTypeEscouade());
			comboEquipement.setSelectedItem(vectEscouade.get(numCombo)
					.getEquipementSupp());
			comboEscouadeArme.setSelectedItem(vectEscouade.get(numCombo)
					.getArmePrincipale());

			for (int i = 0; i < vectSgt.size(); i++) {

				if (vectEscouade.get(numCombo).getFKOfficier().equals(
						vectSgt.get(i).getNomOfficier()) == true) {

					comboSergent.setSelectedItem(vectSgt.get(i)
							.getMainDroiteOfficier());
					textFNomSergent.setText(vectSgt.get(i).getNomOfficier());
					// on quitte pour la rapidité
					break;
				}
			}

		}
	}

	private class MyButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == butEncoder) {
				majEscouade();

			}

		}
	}

}
