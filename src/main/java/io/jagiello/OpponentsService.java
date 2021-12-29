package io.jagiello;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import static io.jagiello.Screen.SCREEN_HEIGHT;

public class OpponentsService {
    private Queue<HorizontalPosition> opponents = new LinkedList<>();

    private int lastAddOpponent = 0;
    private int newAddOpponent = 0;
    private boolean newAddOpponentDrawn = false;

    private int opponentCounter = 0;

    public OpponentsService() {
        for(int i = 0; i < SCREEN_HEIGHT; i++){
            opponents.add(null);
        }
    }

    public void prepareOpponents() {
        opponentCounter--;
        opponents.remove();

        if (newAddOpponent != lastAddOpponent && newAddOpponentDrawn ){
            opponentCounter += 6;
            newAddOpponentDrawn = false;
        }

        if (opponentCounter < 1 ) {
            opponentCounter = 5 + ThreadLocalRandom.current().nextInt(0,4);;

            if ( newAddOpponent == 0 ){
                opponents.add(HorizontalPosition.LEFT);
            } else {
                opponents.add(HorizontalPosition.RIGHT);
            }
            lastAddOpponent = newAddOpponent;
            newAddOpponent = ThreadLocalRandom.current().nextInt(0,2);
            newAddOpponentDrawn = true;
        } else {
            opponents.add(null);
        }
    }

    public Queue<HorizontalPosition> getOpponents() {
        return opponents;
    }

}
