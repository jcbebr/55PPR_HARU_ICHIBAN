package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameOverStage extends GameStage {

    public GameOverStage(GameController controller) {
        super(controller);
        super.name = "Game over";
        super.info = "";
    }

    @Override
    public void nextStage() {
        //controller.setStage(new GameStage01(controller));
    }

    @Override
    public void doStage(BoardController b) {
        //throw new UnsupportedOperationException();
    }

}
