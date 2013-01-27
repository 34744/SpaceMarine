package view;

import javax.swing.*;
import javax.swing.plaf.multi.MultiButtonUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionBD extends JDialog {

	// VARIABLES
	private JLabel labID, labPass;
	JTextField textID;
	private JPasswordField pass;
	private JButton butOK;
	private JPanel pan;

	// CONSTRUCTEUR
	public ConnectionBD() {
		this.setTitle("Fenêtre de connection");
		this.setModal(true);
		this.setResizable(false);
		this.setBounds(0, 0, 350, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		pan = new JPanel();
		pan.setBounds(350, 200, 150, 150);
		pan.setLayout(null);

		labID = new JLabel("Identifiant: ");
		labID.setBounds(50, 50, 100, 24);

		labPass = new JLabel("Mot de passe: ");
		labPass.setBounds(50, 75, 100, 24);

		textID = new JTextField();
		textID.setBounds(150, 50, 100, 24);

		pass = new JPasswordField();
		pass.setBounds(150, 75, 100, 24);

		butOK = new JButton("Next");
		butOK.setBounds(200, 125, 75, 24);

		pan.add(labID);
		pan.add(labPass);
		pan.add(textID);
		pan.add(pass);
		pan.add(butOK);

		this.add(pan);

		MyButtonListener list = new MyButtonListener();
		butOK.addActionListener(list);

		this.setVisible(true);

	}

	private class MyButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == butOK) {
				model.AccessBD.accessBD("SMDB", textID.getText(), pass
						.getText());
				if (model.AccessBD.getConnection() != null) {
					// destruction
					dispose();
					view.MainJFrame.refreshPanelPrincipal();
				}
			}

		}

	}

}
