package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class DeleteVeh extends JPanel {

	// constantes
	private final static String IMAGE = ".\\image\\listerVehicule.jpg";

	// variables
	private Image background;
	private JTable tableVehicule;
	private ModelJTableVehicule modelVehicule;
	private JButton butSupp;
	private ListSelectionModel listSelected;
	private JScrollPane JSP;

	private Vector<model.Veh> vectVeh;

	public DeleteVeh() {
		this.setBounds(0, 0, view.MainJFrame.getRectPanelPrincipal().width,
				view.MainJFrame.getRectPanelPrincipal().height);

		// image de fond
		background = getToolkit().getImage(IMAGE);
		this.setLayout(null);

		vectVeh = new Vector<model.Veh>();
		vectVeh = controller.GestionBD.getVeh();

		modelVehicule = new ModelJTableVehicule(vectVeh);

		tableVehicule = new JTable(modelVehicule);
		tableVehicule.setAutoscrolls(true);
		tableVehicule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelected = tableVehicule.getSelectionModel();

		MyMouseListener mouseListener = new MyMouseListener();
		tableVehicule.addMouseListener(mouseListener);

		JSP = new JScrollPane(tableVehicule);
		JSP.setBounds(25, 100, 974, 400);

		butSupp = new JButton("Supprimer");
		butSupp.setBounds(900, 600, 100, 24);

		MyButtonListener buttonListener = new MyButtonListener();
		butSupp.addActionListener(buttonListener);

		this.add(JSP);
		this.add(butSupp);
		this.setVisible(true);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
	}

	private class MyMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == butSupp) {
				int indice = listSelected.getMinSelectionIndex();
				if (indice != -1) {
					controller.GestionBD.effacerVeh(String
							.valueOf(modelVehicule.getValueAt(indice, 0)));
					Vector<model.Veh> vectVeh = new Vector<model.Veh>();
					vectVeh = controller.GestionBD.getVeh();
					modelVehicule.setContents(vectVeh);
					JSP.repaint();
				}
			}
		}

	}
}
