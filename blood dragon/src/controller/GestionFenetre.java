package controller; 

public class GestionFenetre {

	public static void initAccueil() {
		view.Accueil acc = new view.Accueil();
		view.MainJFrame.setContainerPanelPrincipal(acc);
	}

	public static void eraseContainerPanelPrincipalMainJFrame() {
		view.MainJFrame.eraseContainerPanelPrincipal();
	}

	public static void initConnectionBD() {
		view.ConnectionBD connect = new view.ConnectionBD();
	}

	public static void ajoutEscouade() {
		view.AddEscouade addE = new view.AddEscouade();
		view.MainJFrame.setContainerPanelPrincipal(addE);
	}

	public static void listerVehicule() {
		view.ListingVehicule LV = new view.ListingVehicule();
		view.MainJFrame.setContainerPanelPrincipal(LV);
	}

	public static void listerEscouade() {
		view.ListingEscouade LE = new view.ListingEscouade();
		view.MainJFrame.setContainerPanelPrincipal(LE);

	}

	public static void ajoutOfficier() {
		view.AddOfficier addO = new view.AddOfficier();
		view.MainJFrame.setContainerPanelPrincipal(addO);
	}

	public static void initThread() {
		view.PanelBanniere panelBan = new view.PanelBanniere();
		view.PanelAccueil panelAccueil = new view.PanelAccueil();

		view.MainJFrame.setContainerPanelPrevious(panelAccueil);
		view.MainJFrame.setContainerPanelPreviousBis(panelBan);

		panelBan.addImage(".\\image\\gamesworkshop.jpg");
		panelBan.addImage(".\\image\\warhammer40000.jpg");

		panelAccueil.setBounds(0, 0, 1024, 20);
		panelBan.setBounds(0, 0, 1024, 48);

		view.ThreadBanniere thread1 = new view.ThreadBanniere(panelBan, 5000);

		thread1.start();
	}

	public static void majEscouade() {
		view.UpdateEscouade UE = new view.UpdateEscouade();
		view.MainJFrame.setContainerPanelPrincipal(UE);
	}

	public static void suppVeh() {
		view.DeleteVeh DV = new view.DeleteVeh();
		view.MainJFrame.setContainerPanelPrincipal(DV);

	}

	public static void listerArme() {
		view.ListingArme LA = new view.ListingArme();
		view.MainJFrame.setContainerPanelPrincipal(LA);
	}
	

}
