package io.jagiello;

import java.util.Queue;

public class GameEngine {

    private OpponentsService opponentsService;
    private PlayerBolide playerBolide;
    private Screen screen;

    private boolean collision = false;
    private HorizontalPosition opponentCollisionPositionX = HorizontalPosition.LEFT;
    private int opponentCollisionPositionY = 0;

    public GameEngine(OpponentsService opponentsService, PlayerBolide playerBolide, Screen screen) {
        this.opponentsService = opponentsService;
        this.playerBolide = playerBolide;
        this.screen = screen;
    }

    private void checkCollision(Queue<HorizontalPosition> opponents){
        int opponentPos = 24;
        for(HorizontalPosition opponentPosition : opponents){
            if (opponentPosition != null && opponentPos > 15 && playerBolide.getPosition() == opponentPosition){
                collision = true;
                opponentCollisionPositionX = opponentPosition;
                opponentCollisionPositionY = opponentPos;
            }
            opponentPos--;
            if(opponentPos < 0 ) break;
        }
    }

    public void prepareFrame(){
        if(collision){
            screen.prepareScreenCollision(playerBolide, opponentCollisionPositionX.screenPosition, opponentCollisionPositionY);
        } else {
            opponentsService.prepareOpponents();
            checkCollision(opponentsService.getOpponents());
            screen.prepareScreen(playerBolide, opponentsService.getOpponents());
        }
    }
}
