package logic;

public class ShipPlacement {

    public final Ship ship;
    public final int x;
    public final int y;
    public final ShipOrientation orientation;

    public ShipPlacement(Ship ship, int x, int y, ShipOrientation orienation) {
        this.orientation = orienation;
        this.ship = ship;
        this.x = x;
        this.y = y;
    }
}
