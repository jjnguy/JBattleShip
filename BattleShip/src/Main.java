import gui.BattleShipFrame;
import gui.ViewMode;
import logic.ShipGrid;

public class Main {

	public static void main(String[] args) {
		new BattleShipFrame(ShipGrid.randomlyPlaceShips(new ShipGrid()), ViewMode.Guess).setVisible(true);
	}
}
