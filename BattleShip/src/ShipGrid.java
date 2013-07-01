public class ShipGrid {

	private static final int GRID_SIZE = 10;

	private GridSpace[][] grid;

	private int shipSpacesRemaining;

	public ShipGrid() {
		grid = new GridSpace[10][10];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new GridSpace();
			}
		}
	}

	public void placeShip(int x, int y, int length, ShipOrientation orientation) {
		if (orientation == ShipOrientation.Vertical) {
			for (int i = x; i < x + length; i++) {
				grid[i][y].placeShip();
				shipSpacesRemaining++;
			}
		} else {
			for (int i = y; i < y + length; i++) {
				grid[x][i].placeShip();
				shipSpacesRemaining++;
			}
		}
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
		boolean result = grid[x][y].guess();
		if (result) {
			shipSpacesRemaining--;
		}
		return result;
	}

	public boolean gameOver() {
		return shipSpacesRemaining == 0;
	}

	public static void randomlyPlaceShips(ShipGrid grid) {
		grid.placeShip(0, 1, 5, ShipOrientation.Horizontal);
		grid.placeShip(0, 0, 4, ShipOrientation.Vertical);
		grid.placeShip(3, 1, 3, ShipOrientation.Vertical);
		grid.placeShip(5, 5, 3, ShipOrientation.Vertical);
		grid.placeShip(8, 1, 2, ShipOrientation.Vertical);
	}
}
