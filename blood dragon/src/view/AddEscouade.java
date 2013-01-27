package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEscouade extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\ajoutEscouade.jpg";

	// variables
	private Image background;
	private JComboBox comboEscouade, comboSergent, comboNbMembre,
			comboEquipement, comboEscouadeArme;
	private JLabel labelEscouade, labelSergent, labelNbMembre, labelEquipement;
	private JTextField textFNomEscouade, textFNomSergent,
			textFSergentMainGauche;
	private JButton butEncoder;
	private String nomEscouade, typeEscouade, armePrincipale, equipementSupp,
			fKOfficier;
	private String nomOfficier, typeOfficier, mainDroiteOfficier,
			mainGaucheOfficier, equipementOfficier;
	private int nbMembre;

	public AddEscouade() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);

		butEncoder = new JButton("Next");
		butEncoder.setBounds(900, 600, 100, 24);

		// JComboBox
		comboEscouade = new JComboBox();
		comboEscouade.addItem("Tactique");
		comboEscouade.addItem("Assaut");
		comboEscouade.addItem("Devastator");
		comboEscouade.addItem("Veterant");
		comboEscouade.setBounds(10, 10, 100, 24);

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

		labelSergent = new JLabel("Nom du sergent: ");
		labelSergent.setBounds(550, 60, 150, 24);
		textFNomSergent = new JTextField();
		textFNomSergent.setBounds(680, 60, 200, 24);

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

		MyButtonListener list = new MyButtonListener();
		butEncoder.addActionListener(list);

		this.setVisible(true);
	}

	public boolean ajouterEscouade() {

		try {
			nomEscouade = textFNomEscouade.getText();

			typeEscouade = String.valueOf(comboEscouade.getItemAt(comboEscouade
					.getSelectedIndex()));

			armePrincipale = String.valueOf(comboEscouadeArme
					.getItemAt(comboEscouadeArme.getSelectedIndex()));

			nbMembre = Integer.parseInt(String.valueOf(comboNbMembre
					.getItemAt(comboNbMembre.getSelectedIndex())));

			equipementSupp = String.valueOf(comboEquipement
					.getItemAt(comboEquipement.getSelectedIndex()));

			fKOfficier = textFNomSergent.getText();

			nomOfficier = textFNomSergent.getText();

			typeOfficier = "Sergent vétérant";

			mainGaucheOfficier = textFSergentMainGauche.getText();

			mainDroiteOfficier = String.valueOf(comboSergent
					.getItemAt(comboSergent.getSelectedIndex()));

			equipementOfficier = String.valueOf(comboEquipement
					.getItemAt(comboEquipement.getSelectedIndex()));

			return true;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e, "Erreur Type",
					JOptionPane.ERROR_MESSAGE);

			return false;

		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == butEncoder) {
				if (ajouterEscouade() == true) {

					model.Escouade newB = new model.Escouade(nomEscouade,
							typeEscouade, armePrincipale, equipementSupp,
							fKOfficier, nomOfficier, typeOfficier,
							mainDroiteOfficier, mainGaucheOfficier,
							equipementOfficier, nbMembre);
					switch (JOptionPane
							.showConfirmDialog(
									null,
									newB
											+ "\n\nEtes-vous sur de vouloir procéder à la mise à jour?",
									"RESUME", JOptionPane.INFORMATION_MESSAGE)) {

					case JOptionPane.YES_OPTION:
						controller.GestionBD.addEscouade(newB);

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
