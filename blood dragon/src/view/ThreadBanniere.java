package view;

public class ThreadBanniere extends Thread {
	private int nbImage;
	private int wait;

	private view.PanelBanniere pBan;

	public ThreadBanniere(PanelBanniere pBan, int wait) {
		this.pBan = pBan;
		nbImage = pBan.getVectorImage().size();
		setWait(wait);

	}

	public void run() {
		int i = 0;

		while (true) {
			pBan.setImage(pBan.getVectorImage().get(i));

			pBan.repaint();

			i++;
			if (i >= nbImage)
				i = 0;

			try {
				Thread.sleep(wait);
			} catch (InterruptedException iE) {
				System.out.println(iE);
			}
		}
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

}
