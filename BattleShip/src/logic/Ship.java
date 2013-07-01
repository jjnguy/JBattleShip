package logic;
public class Ship {

	public final int length;
	public final ShipOrientation orientation;

	private int hitsRemaining;

	public Ship(int length, ShipOrientation orientation) {
		this.length = length;
		hitsRemaining = length;
		this.orientation = orientation;
	}

	public boolean hit() {
		if (isSunk()) {
			throw new RuntimeException("Cannot hit already sunk ship");
		}
		hitsRemaining--;
		return hitsRemaining == 0;
	}

	public boolean isSunk() {
		return hitsRemaining == 0;
	}

	public static Ship vertical(int length){
		return new Ship(length, ShipOrientation.Vertical);
	}
	public static Ship horizontal(int length){
		return new Ship(length, ShipOrientation.Horizontal);
	}
}
