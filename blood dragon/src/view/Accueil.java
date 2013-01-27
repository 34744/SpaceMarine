package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Accueil extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\menu.jpg";
	// private final static Color FOREGROUND_COLOR = new Color(255,255,255);

	// variables
	private JLabel labListe, labAjout, labSuppression, labModifier;
	private JButton butInsererEscouade, butInsererOfficier, butListerVehicule,
			butListerEscouade, butModifierEscouade, butSupprimerVeh, butListerArme;
	private Image background;
	private JTabbedPane myTabbedPane;
	private JPanel acc;

	// constructeur

	public Accueil() {

		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);
		// image de fond
		background = getToolkit().getImage(IMAGE);
		this.setLayout(null);

		butInsererEscouade = new JButton("Ajouter une escouade");
		this.setStyleButton(butInsererEscouade, false, Color.black, Color.cyan);
		butInsererEscouade.setBounds(50, 50, 200, 50);

		butInsererOfficier = new JButton("Ajouter un officier");
		this.setStyleButton(butInsererOfficier, false, Color.black, Color.cyan);
		butInsererOfficier.setBounds(50, 150, 200, 50);

		butListerEscouade = new JButton("Liste les escouades");
		this.setStyleButton(butListerEscouade, false, Color.black, Color.cyan);
		butListerEscouade.setBounds(290, 50, 200, 50);

		butListerVehicule = new JButton("Liste les véhicules");
		this.setStyleButton(butListerVehicule, false, Color.black, Color.cyan);
		butListerVehicule.setBounds(290, 150, 200, 50);
		
		butListerArme = new JButton("Liste les Armes");
		this.setStyleButton(butListerArme, false, Color.black, Color.cyan);
		butListerArme.setBounds(290, 250, 200, 50);

		butModifierEscouade = new JButton("Modifier une escouade");
		this
				.setStyleButton(butModifierEscouade, false, Color.black,
						Color.cyan);
		butModifierEscouade.setBounds(530, 50, 200, 50);

		butSupprimerVeh = new JButton("supprimer un vehicule");
		this.setStyleButton(butSupprimerVeh, false, Color.black, Color.cyan);
		butSupprimerVeh.setBounds(760, 50, 200, 50);

		this.add(butInsererEscouade);
		this.add(butInsererOfficier);
		this.add(butListerVehicule);
		this.add(butListerEscouade);
		this.add(butModifierEscouade);
		this.add(butSupprimerVeh);
		this.add(butListerArme);

		MyButtonListener myListener = new MyButtonListener();

		// on écoute les bouttons
		butInsererEscouade.addActionListener(myListener);
		butInsererOfficier.addActionListener(myListener);
		butListerVehicule.addActionListener(myListener);
		butListerEscouade.addActionListener(myListener);
		butListerArme.addActionListener(myListener);
		butModifierEscouade.addActionListener(myListener);
		butSupprimerVeh.addActionListener(myListener);

		this.setVisible(true);
	}

	/*
	 * petite fonction servant à appliquer a un style bien particulier à un
	 * boutton
	 */
	public void setStyleButton(JButton button, boolean opaque,
			Color background, Color foreground) {
		button.setOpaque(opaque);
		button.setBackground(background);
		button.setForeground(foreground);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}

	private class MyButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == butInsererEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.ajoutEscouade();
			}

			if (source == butInsererOfficier) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.ajoutOfficier();
			}

			if (source == butListerVehicule) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerVehicule();
			}

			if (source == butListerEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerEscouade();

			}
			
			if (source == butListerArme){
				controller.GestionFenetre
					.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerArme();
			}

			if (source == butModifierEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.majEscouade();
			}

			if (source == butSupprimerVeh) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.suppVeh();
			}
		}

	}

}
