package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage04 extends GameStage {

    public GameStage04(GameController controller) {
        super(controller);
        super.name = "Etapa 03 - Jogada do jardineiro sênior";
        super.info = "Posicione sua peça";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage05(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE04();
    }

}
