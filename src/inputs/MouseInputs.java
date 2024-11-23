package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener {

	private GamePanel gamePanel;

	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		gamePanel.setRectPos(e.getX(), e.getY());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked!");
		gamePanel.spawnRect(e.getX(),e.getY());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed!");
		gamePanel.setRectPos(e.getX(), e.getY());
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released!");
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered!");
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited!");
		// TODO Auto-generated method stub

	}

}
