import java.util.ArrayList;
import java.util.List;

public class ShipGrid {

	private static final int GRID_SIZE = 10;

	private GridSpace[][] grid;

	private int shipSpacesRemaining;
	
	private List<Ship> ships;

	public ShipGrid() {
		grid = new GridSpace[10][10];
		ships = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new GridSpace();
			}
		}
	}

	public void placeShip(int x, int y, Ship ship, ShipOrientation orientation) {
		if (orientation == ShipOrientation.Vertical) {
			for (int i = x; i < x + ship.length; i++) {
				grid[i][y].placeShip(ship);
				shipSpacesRemaining++;
			}
		} else {
			for (int i = y; i < y + ship.length; i++) {
				grid[x][i].placeShip(ship);
				shipSpacesRemaining++;
			}
		}
		ships.add(ship);
	}
	
	public List<Ship> remainingShips(){
		List<Ship> results = new ArrayList<>(ships.size());
		for (Ship ship : ships) {
			if (!ship.isSunk()){
				results.add(ship);
			}
		}
		return results;
	}

	public void print() {
		System.out.print("  ");
		for (int i = 0; i < GRID_SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i < GRID_SIZE; i++) {
			System.out.print("- ");
		}
		System.out.println();
		for (int i = 0; i < grid.length; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println();
		System.out.println();
	}

	public boolean guess(int x, int y) {
		GuessResult result = grid[x][y].guess();
		if (result.hit) {
			shipSpacesRemaining--;
		}
		return result.hit;
	}

	public boolean isGameOver() {
		return shipSpacesRemaining == 0;
	}

	public static void randomlyPlaceShips(ShipGrid grid) {
		grid.placeShip(0, 1, Ship.of(5), ShipOrientation.Horizontal);
		grid.placeShip(0, 0, Ship.of(4), ShipOrientation.Vertical);
		grid.placeShip(3, 1, Ship.of(3), ShipOrientation.Vertical);
		grid.placeShip(5, 5, Ship.of(3), ShipOrientation.Vertical);
		grid.placeShip(8, 1, Ship.of(2), ShipOrientation.Vertical);
	}
}
