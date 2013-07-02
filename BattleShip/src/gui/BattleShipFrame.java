package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.GridSpace;
import logic.GuessResult;
import logic.ShipGrid;
import logic.ShipOrientation;

public class BattleShipFrame extends JFrame {

	private static final long serialVersionUID = -2843270519100916735L;

	private ShipGrid logic;
	private ViewMode view;

	public BattleShipFrame(ShipGrid grid, ViewMode mode) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(grid.getWidth(), grid.getWidth()));
		logic = grid;
		view = mode;
		setBackground(Color.WHITE);
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				add(new Square(grid.get(i, j), view));
			}
		}
		pack();
	}

	private class Square extends JPanel {

		private final GridSpace logic;
		private final ViewMode view;

		public Square(GridSpace space, ViewMode mode) {
			logic = space;
			this.view = mode;
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (view == ViewMode.Master) {
						return;
					}
					if (!logic.isGuessed()) {
						GuessResult result = logic.guess();
						if (result.hit && result.ship.isSunk()) {
							getParent().repaint();
							if (BattleShipFrame.this.logic.isGameOver()) {
								System.exit(0);
							}
						} else {
							repaint();
						}
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			if (logic.isOccupied() && (view == ViewMode.Master || logic.isGuessed())) {
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
