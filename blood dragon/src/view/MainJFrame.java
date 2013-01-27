package view;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class MainJFrame extends JFrame {

	// variables
	private static JPanel panelPrincipal, panelPrevious, panelPreviousBis;
	private Container cont;
	private JMenuBar barre;
	private JMenu menuFichier, menuChapitre, menuBD, itemMenuListing,
			itemMenuAjout, itemMenuSuppression, itemMenuModif;
	private JMenuItem itemAccueil, itemQuitter;
	private JMenuItem itemListingVehicule, itemListingEscouade,
			itemAjoutEscouade, itemAjoutOfficier, itemMajEscouade, itemSuppVeh,
			itemListingArme;

	public MainJFrame(String title, int x, int y, int lx, int ly,
			boolean AlwaysOnTop) {
		super(title);
		custom(x, y, lx, ly, AlwaysOnTop);
		// recuperer le container
		cont = this.getContentPane();

		// gestion de [X]
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				clotApplication();
			}
		});
		// panneaux principaux
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 48, 1024, 650);
		panelPrincipal.setLayout(null);

		panelPrevious = new JPanel();
		panelPrevious.setBounds(0, 700, 1024, 20);
		panelPrevious.setLayout(null);

		panelPreviousBis = new JPanel();
		panelPreviousBis.setBounds(0, 0, 1024, 48);
		panelPreviousBis.setLayout(null);

		cont.add(panelPrincipal);
		cont.add(panelPrevious);
		cont.add(panelPreviousBis);

		// creation du JMenu
		initMenu();

		// initialisation de l'accueil et du thread
		controller.GestionFenetre.initAccueil();
		controller.GestionFenetre.initThread();

		// rendre visible
		this.setVisible(true);
	}

	public void custom(int x, int y, int lx, int ly, boolean AlwaysOnTop) {
		this.setBounds(x, y, lx, ly);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(AlwaysOnTop);
		this.setBackground(new Color(150, 150, 175));
		this.setResizable(false);
	}

	public void initMenu() {
		barre = new JMenuBar();
		setJMenuBar(barre);

		menuFichier = new JMenu("menu");
		menuChapitre = new JMenu("Blood Dragon");
		menuBD = new JMenu("Accès BD");

		itemAccueil = new JMenuItem("Accueil");
		itemQuitter = new JMenuItem("Quitter");

		itemMenuAjout = new JMenu("Ajouter");
		itemMenuListing = new JMenu("Lister");
		itemMenuModif = new JMenu("Modifier");
		itemMenuSuppression = new JMenu("Supprimer");

		itemListingVehicule = new JMenuItem("Vehicule");
		itemListingEscouade = new JMenuItem("Escouade");
		itemListingArme = new JMenuItem("Arme");
		
		itemAjoutEscouade = new JMenuItem("Escouade");
		itemAjoutOfficier = new JMenuItem("Officier");

		itemMajEscouade = new JMenuItem("Escouade");

		itemSuppVeh = new JMenuItem("Vehicule");

		// ajout ds les >
		itemMenuAjout.add(itemAjoutEscouade);
		itemMenuAjout.add(itemAjoutOfficier);
		itemMenuListing.add(itemListingVehicule);
		itemMenuListing.add(itemListingEscouade);
		itemMenuListing.add(itemListingArme);
		itemMenuModif.add(itemMajEscouade);
		itemMenuSuppression.add(itemSuppVeh);

		menuFichier.add(itemAccueil);
		menuFichier.add(itemQuitter);

		menuChapitre.add(itemMenuAjout);
		menuChapitre.add(itemMenuListing);
		menuChapitre.add(itemMenuModif);
		menuChapitre.add(itemMenuSuppression);

		barre.add(menuFichier);
		barre.add(menuChapitre);
		// barre.add(menuBD);

		MyActionListener listener = new MyActionListener();
		itemAccueil.addActionListener(listener);
		itemQuitter.addActionListener(listener);
		itemMenuAjout.addActionListener(listener);
		itemMenuListing.addActionListener(listener);
		itemMenuModif.addActionListener(listener);
		itemMenuSuppression.addActionListener(listener);
		itemAjoutEscouade.addActionListener(listener);
		itemAjoutOfficier.addActionListener(listener);
		itemListingVehicule.addActionListener(listener);
		itemListingEscouade.addActionListener(listener);
		itemListingArme.addActionListener(listener);
		itemMajEscouade.addActionListener(listener);
		itemSuppVeh.addActionListener(listener);
		
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	public void clotApplication() {
		if (model.AccessBD.getConnection() != null)
			controller.GestionBD.fermerBD();
		System.exit(0);
	}

	public static void refreshPanelPrevious() {
		panelPrevious.repaint();
		panelPrevious.setVisible(false);
		panelPrevious.setVisible(true);
	}

	public static void refreshPanelPreviousBis() {
		panelPreviousBis.repaint();
		panelPreviousBis.setVisible(false);
		panelPreviousBis.setVisible(true);
	}

	public static void refreshPanelPrincipal() {
		panelPrincipal.repaint();
		panelPrincipal.setVisible(false);
		panelPrincipal.setVisible(true);
	}

	public static void setContainerPanelPrincipal(Component arg0) {
		panelPrincipal.add(arg0);
	}

	
	public static void eraseContainerPanelPrincipal() {
		try {
			panelPrincipal.remove(panelPrincipal.getComponent(0));
			refreshPanelPrincipal();

		} catch (ArrayIndexOutOfBoundsException error) {
			JOptionPane.showMessageDialog(null, error,
					"Erreur ArrayIndexOutOfBoundsException",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void setContainerPanelPrevious(Component arg0) {
		panelPrevious.add(arg0);
	}

	public static void eraseContainerPanelPrevious() {
		panelPrevious.remove(panelPrevious.getComponent(0));
		refreshPanelPrevious();
	}

	public static void setContainerPanelPreviousBis(Component arg0) {
		panelPreviousBis.add(arg0);
	}

	public static void eraseContainerPanelPreviousBis() {
		panelPrevious.remove(panelPrevious.getComponent(0));
		refreshPanelPreviousBis();
	}

	public static Rectangle getRectPanelPrincipal() {
		return panelPrincipal.getBounds();
	}

	public static Color getColorPanelPrincipal() {
		return panelPrincipal.getBackground();
	}

	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == itemAccueil) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.initAccueil();

			}
			if (source == itemAjoutEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.ajoutEscouade();
			}

			if (source == itemQuitter)
				clotApplication();

			if (source == itemAjoutOfficier) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.ajoutOfficier();
			}
			if (source == itemListingVehicule) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerVehicule();
			}
			if (source == itemListingEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerEscouade();
			}
			if (source == itemMajEscouade) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.majEscouade();
			}

			if (source == itemSuppVeh) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.suppVeh();

			}
			if (source == itemListingArme){
				controller.GestionFenetre
					.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.listerArme();
			}
		}
	}

}
