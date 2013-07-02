package logic;

import java.util.List;

public class ProbabilityCalculator {

    private ShipGrid grid;

    public ProbabilityCalculator(ShipGrid grid) {
        this.grid = grid;
    }

    public void setProbabilities() {
        List<Ship> remainingShips = grid.remainingShips();
        // not sure what to do here...
    }

}
