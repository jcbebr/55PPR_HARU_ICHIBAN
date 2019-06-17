package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage07 extends GameStage {

    public GameStage07(GameController controller) {
        super(controller);
        super.name = "Etapa 04 - Haru Ichiban";
        super.info = "Jardineiro junior indica a direção";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage08(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE07();
    }

}
