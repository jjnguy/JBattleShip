package logic;
import java.util.ArrayList;
import java.util.List;

public class ShipGrid {

	private static final int GRID_SIZE = 10;

	private GridSpace[][] grid;
	
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

	public int getWidth(){
		return GRID_SIZE;
	}
	
	public GridSpace get(int x, int y){
		return grid[x][y];
	}
	
	public void placeShip(int x, int y, Ship ship) {
		if (ship.orientation == ShipOrientation.Vertical) {
			for (int i = x; i < x + ship.length; i++) {
				grid[i][y].placeShip(ship);
			}
		} else {
			for (int i = y; i < y + ship.length; i++) {
				grid[x][i].placeShip(ship);
			}
		}
		ships.add(ship);
	}
	
	public void addListenerToAllSquares(SquareGuessListenters listener){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j].addListener(listener);
			}
		}
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

	public boolean isGameOver() {
		return remainingShips().size() == 0;
	}

	public static ShipGrid randomlyPlaceShips(ShipGrid grid) {
		grid.placeShip(0, 1, Ship.horizontal(5));
		grid.placeShip(0, 0, Ship.vertical(4));
		grid.placeShip(3, 1, Ship.vertical(3));
		grid.placeShip(5, 5, Ship.vertical(3));
		grid.placeShip(8, 1, Ship.vertical(2));
		return grid;
	}
}
