package logic;

import java.util.ArrayList;
import java.util.List;

public class GridSpace {

	private boolean guessed;
	private boolean occupied;
	private ShipPlacement occupant;
	
	private double occupiedProbability;
	
	private List<SquareGuessListenters> listeners;

	public GridSpace() {
		guessed = false;
		occupied = false;
		listeners = new ArrayList<SquareGuessListenters>();
	}

	public GuessResult guess() {
		guessed = true;
		if (occupied) {
			occupant.ship.hit();
		}
		GuessResult result = new GuessResult(occupied, occupant.ship);
		for (SquareGuessListenters listener : listeners) {
			listener.onGuess(this, result);
		}
		return result;
	}
	
	public void addListener(SquareGuessListenters listener){
		listeners.add(listener);
	}

	public void placeShip(ShipPlacement ship) {
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
	
	public ShipPlacement getOccupant(){
		if (!isOccupied()){
			throw new RuntimeException("Cannot get occupant of unoccupied space");
		}
		return occupant;
	}
	
	public double getOccupiedProbability(){
	    return occupiedProbability;
	}
	
	public void setOccupiedProbability(double probability){
	    occupiedProbability = probability;
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
