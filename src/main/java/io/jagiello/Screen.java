package io.jagiello;

import java.util.Queue;

public class Screen {
    public static int SCREEN_WIDTH = 11;
    public static int SCREEN_HEIGHT = 30;

    private static final int PLAYER_VERTICAL_POSITION = SCREEN_HEIGHT - 10;

    private int borderBreakStart = 3;

    private int crashFrame = 0;

    private char[][] screen = new char[SCREEN_WIDTH][SCREEN_HEIGHT];

    public Screen() {}

    public StringBuffer getScreen() {
        StringBuffer screenBuffer = new StringBuffer();
        for(int h = 5; h < SCREEN_HEIGHT - 5; h++){
            for(int w = 0; w < SCREEN_WIDTH; w++){
                screenBuffer.append(screen[w][h]);
                screenBuffer.append(screen[w][h]);
            }
            screenBuffer.append('\n');
        }

        return screenBuffer;
    }

    public void cleanScreen() {
        for(int h = 0; h < SCREEN_HEIGHT; h++){
            for(int w = 0; w < SCREEN_WIDTH; w++){
                screen[w][h] = ' ';
            }
        }
    }

    public void drawBorders() {
        for(int h = 0; h < SCREEN_HEIGHT; h++){
            char border = (h + borderBreakStart) % 4 == 0 ? ' ' : '#';
            screen[0][h] = border;
            screen[SCREEN_WIDTH - 1][h] = border;
        }
        borderBreakStart--;
        if (borderBreakStart < 0) {
            borderBreakStart = 3;
        }
    }

    private void drawBolide(int x, int y, char[][] bolide){
        for(int bh = 0; bh < Bolide.HEIGHT; bh++){
            for(int bw = 0; bw < Bolide.WIDTH; bw++){
                screen[x + bw][y + bh] = bolide[bh][bw];
            }
        }
    }

    public void drawPlayerBolide(PlayerBolide playerBolide, char[][] bolide) {
        int playerBolidePosition = playerBolide.getPosition().screenPosition;
        drawBolide(playerBolidePosition, PLAYER_VERTICAL_POSITION, bolide);
    }

    public void drawOpponents(Queue<HorizontalPosition> opponentsPositions) {
        int opponentPos = 24;
        for(HorizontalPosition opponentPosition : opponentsPositions){
            if (opponentPosition != null) {
                drawBolide(opponentPosition.screenPosition, opponentPos, Bolide.BOLIDE);
            }
            opponentPos--;
            if(opponentPos < 0 ) break;
        }
    }

    public void prepareScreenCollision(PlayerBolide playerBolide, int opponentCollisionX, int opponentCollisionY){
        if (crashFrame == 0){
            drawPlayerBolide(playerBolide, Bolide.CRASH_BOLIDE_1);
            drawBolide(opponentCollisionX, opponentCollisionY, Bolide.CRASH_BOLIDE_2);
        } else {
            drawPlayerBolide(playerBolide, Bolide.CRASH_BOLIDE_2);
            drawBolide(opponentCollisionX, opponentCollisionY, Bolide.CRASH_BOLIDE_1);
        }
        crashFrame++;
        crashFrame = crashFrame > 1 ? 0 : crashFrame;
    }

    public void prepareScreen(PlayerBolide playerBolide, Queue<HorizontalPosition> opponentsPositions) {
        cleanScreen();
        drawOpponents(opponentsPositions);
        drawPlayerBolide(playerBolide, Bolide.BOLIDE);
        drawBorders();
    }
}
