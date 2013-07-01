
public class GridSpace {

	private boolean guessed;
	private boolean occupied;
	
	public GridSpace(){
		guessed = false;
		occupied = false;
	}
	
	public boolean guess(){
		guessed = true;
		return occupied;
	}
	
	public void placeShip(){
		if (occupied){
			throw new RuntimeException("Cannot place ships on top of eachother.");
		}
		occupied = true;
	}
	
	@Override
	public String toString() {
		if (!occupied && !guessed){
			return " ";
		}
		if (!occupied && guessed){
			return "X";
		}
		if (occupied && !guessed){
			return "O";
		}
		if (occupied && guessed){
			return "0";
		}
		throw new RuntimeException();
	}
}
