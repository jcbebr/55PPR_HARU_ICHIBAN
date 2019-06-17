package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage06 extends GameStage {

    public GameStage06(GameController controller) {
        super(controller);
        super.name = "Etapa 04 - Haru Ichiban";
        super.info = "Jardineiro junior indica o Nenúfar a ser movido";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage07(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE06();
    }

}
