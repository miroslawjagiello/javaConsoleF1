package io.jagiello;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConsoleF1 {
    public static void main(String[] args) throws IOException, InterruptedException{
        PlayerBolide playerBolide = new PlayerBolide();
        OpponentsService opponentsService = new OpponentsService();
        int score = 0;
        Screen screen = new Screen();

        GameEngine gameEngine = new GameEngine(opponentsService, playerBolide, screen);

        InputController controller = new InputController();

        final int[] keyPressed = {0};
        ConsoleUtils.runKeyListener(keyPressed);

        while (true) {
            controller.movePlayerBolide(keyPressed[0], playerBolide);
            keyPressed[0] = 0;

            gameEngine.prepareFrame();

            ConsoleUtils.drawScreen(screen.getScreen());
            TimeUnit.MILLISECONDS.sleep(150);
            ConsoleUtils.clearScreen();
        }
    }
}
