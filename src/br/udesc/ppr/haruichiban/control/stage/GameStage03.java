package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage03 extends GameStage {

    public GameStage03(GameController controller) {
        super(controller);
        super.name = "Etapa 02 - Jogada do jardineiro júnior";
        super.info = "Posicione sua peça";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage04(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE03();
    }

}
