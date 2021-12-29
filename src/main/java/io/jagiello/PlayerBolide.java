package io.jagiello;

public class PlayerBolide {

    private HorizontalPosition position = HorizontalPosition.LEFT;

    public void turnRight() {
        this.position = HorizontalPosition.RIGHT;
    }

    public void turnLeft() {
        this.position = HorizontalPosition.LEFT;
    }

    public HorizontalPosition getPosition() {
        return position;
    }
}
