import logic.Ship;
import logic.ShipGrid;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShipGrid grid = new ShipGrid();
		ShipGrid.randomlyPlaceShips(grid);
		grid.print();
		grid.guess(5, 8);
		grid.guess(5, 9);
		grid.guess(6, 8);
		grid.guess(4, 8);
		grid.guess(4, 7);
		grid.guess(5, 5);
		grid.print();
		for (Ship s : grid.remainingShips()) {
			System.out.println(s.length);
		}
		grid.guess(8, 1);
		grid.guess(9, 1);
		for (Ship s : grid.remainingShips()) {
			System.out.println(s.length);
		}
		grid.print();
	}
}
