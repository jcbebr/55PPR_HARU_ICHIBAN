package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage08 extends GameStage {

    public GameStage08(GameController controller) {
        super(controller);
        super.name = "Etapa 05 - Escolha do nenúfar escuro";
        super.info = "Jardineiro sênior";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage09(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE08();
    }

}
