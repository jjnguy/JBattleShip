package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.GridSpace;
import logic.ShipGrid;
import logic.ShipOrientation;

public class BattleShipFrame extends JFrame {

	private static final long serialVersionUID = -2843270519100916735L;

	private ShipGrid logic;

	public BattleShipFrame(ShipGrid grid) {
		super();
		logic = grid;
		setBackground(Color.WHITE);
		
	}

	private static class Square extends JPanel {

		private GridSpace logic;

		public Square(GridSpace space) {
			logic = space;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			if (logic.isOccupied()) {
				setBackground(Color.CYAN);
			}
			if (logic.isGuessed()) {
				g2.setStroke(new BasicStroke(2));
				g2.setColor(Color.BLACK);
				g2.drawLine(0, 0, getWidth(), getHeight());
				g2.drawLine(getWidth(), 0, 0, getHeight());
			}
			if (logic.isOccupied() && logic.getOccupant().isSunk()) {
				g2.setColor(Color.RED);
				g2.setStroke(new BasicStroke(2));
				if (logic.getOccupant().orientation == ShipOrientation.Horizontal) {
					g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
				} else {
					g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
				}
			}
		}
	}

}
