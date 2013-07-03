package logic;

import java.util.List;

public class ProbabilityCalculator {

    private ShipGrid grid;

    private int[][] canPlaceShip;

    public ProbabilityCalculator(ShipGrid grid) {
        this.grid = grid;
        canPlaceShip = new int[grid.getWidth()][grid.getWidth()];
    }

    public void setProbabilities() {
        List<Ship> remainingShips = grid.remainingShips();
        for (Ship ship : remainingShips) {
            for (int i = 0; i < grid.getWidth(); i++) {
                for (int j = 0; j < grid.getWidth(); j++) {
                    for (int k = 0; k < ship.length; k++){
                        boolean canPlace = true;
                        GridSpace current = grid.get(i, j);
                    }
                }
            }
        }
    }
}
