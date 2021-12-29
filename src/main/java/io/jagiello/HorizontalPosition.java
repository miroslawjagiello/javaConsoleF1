package io.jagiello;

public enum HorizontalPosition {
    LEFT(2),
    RIGHT(6);

    public final int screenPosition;

    HorizontalPosition(int i) {
        this.screenPosition = i;
    }
}
