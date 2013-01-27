package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAccueil extends JPanel {
	// VARIABLES
	private JButton accueil;

	public PanelAccueil() {
		accueil = new JButton("Accueil");
		MyButtonListener myListener = new MyButtonListener();
		accueil.addActionListener(myListener);

		this.setLayout(new GridLayout());
		this.add(accueil);
		this.setVisible(true);

	}

	private class MyButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == accueil) {
				controller.GestionFenetre
						.eraseContainerPanelPrincipalMainJFrame();
				controller.GestionFenetre.initAccueil();
			}
		}

	}
}