package logic;

public class GuessResult {

	public final boolean hit;
	public final Ship ship;
	
	public GuessResult(boolean hit, Ship ship){
		this.hit = hit;
		this.ship = ship;
	}
}
