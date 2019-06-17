package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage05 extends GameStage {

    public GameStage05(GameController controller) {
        super(controller);
        super.name = "Etapa 03 - Jogada do jardineiro sênior";
        super.info = "Posicione a peça retirada anteriormente";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage06(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE05();
    }

}
