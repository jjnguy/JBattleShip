package logic;
public class GridSpace {

	private boolean guessed;
	private boolean occupied;
	private Ship occupant;

	public GridSpace() {
		guessed = false;
		occupied = false;
	}

	public GuessResult guess() {
		guessed = true;
		if (occupied) {
			occupant.hit();
		}
		return new GuessResult(occupied, occupant);
	}

	public void placeShip(Ship ship) {
		if (occupied) {
			throw new RuntimeException(
					"Cannot place ships on top of eachother.");
		}
		occupant = ship;
		occupied = true;
	}
	
	public boolean isOccupied(){
		return occupied;
	}
	
	public boolean isGuessed(){
		return guessed;
	}
	
	public Ship getOccupant(){
		if (!isOccupied()){
			throw new RuntimeException("Cannot get occupant of unoccupied space");
		}
		return occupant;
	}

	@Override
	public String toString() {
		if (!occupied && !guessed) {
			return " ";
		}
		if (!occupied && guessed) {
			return "X";
		}
		if (occupied && !guessed) {
			return "O";
		}
		if (occupied && guessed) {
			return "0";
		}
		throw new RuntimeException();
	}
}