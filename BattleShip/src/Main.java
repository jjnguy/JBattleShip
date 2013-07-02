import gui.BattleShipFrame;
import gui.ViewMode;
import logic.GuessResult;
import logic.ShipGrid;
import logic.SquareGuessListenters;

public class Main {

	public static void main(String[] args) {
		ShipGrid grid = ShipGrid.randomlyPlaceShips(new ShipGrid());
		final BattleShipFrame guess = new BattleShipFrame(grid, ViewMode.Guess);
		final BattleShipFrame master = new BattleShipFrame(grid, ViewMode.Master);
		
		grid.addListenerToAllSquares(new SquareGuessListenters() {
			@Override
			public void onGuess(GuessResult result) {
				guess.repaint();
				master.repaint();
			}
		});
		
		guess.setVisible(true);
		master.setVisible(true);
	}
}
