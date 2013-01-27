package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelBanniere extends JPanel {

	// VARIABLES
	private Image background;
	private Vector<String> vectImage;

	// CONSTRUCTEUR
	public PanelBanniere() {
		vectImage = new Vector<String>();
		this.setVisible(true);
	}

	public void addImage(String filename) {
		vectImage.add(filename);
	}

	public Vector<String> getVectorImage() {
		return vectImage;
	}

	public void setImage(String filename) {
		background = getToolkit().getImage(filename);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background, 0, 0, this);
	}

}
