package io.jagiello;

public class InputController {
    public static int KEY_LEFT = 68;
    public static int KEY_RIGHT = 67;

    private boolean keyLeft = false;
    private boolean keyRight = false;
    private boolean keyLeftOld = false;
    private boolean keyRightOld = false;
    public void movePlayerBolide(int key, PlayerBolide playerBolide){
        keyRight = key == KEY_RIGHT;
        keyLeft = key == KEY_LEFT;

        if (keyRight && !keyRightOld) {
            playerBolide.turnRight();
        }

        if (keyLeft && !keyLeftOld) {
            playerBolide.turnLeft();
        }
        keyRightOld = keyRight;
        keyLeftOld = keyLeft;
    }
}
