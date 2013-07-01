public class Ship {

	public final int length;

	private int hitsRemaining;

	public Ship(int length) {
		this.length = length;
		hitsRemaining = length;
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

	public static Ship of(int length){
		return new Ship(length);
	}
}
