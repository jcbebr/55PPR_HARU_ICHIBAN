package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage09 extends GameStage {

    public GameStage09(GameController controller) {
        super(controller);
        super.name = "Etapa 05 - Escolha do nenúfar escuro";
        super.info = "Posicione a peça retirada anteriormente";
    }

    @Override
    public void nextStage() {
        controller.getRedHandController().removeGardener();
        controller.getYellowHandController().removeGardener();
        controller.setStage(new GameStage01(controller));
        controller.unselectCards();
        if (controller.getRedHandController().getDeck().isEmpty()
                || controller.getYellowHandController().getDeck().isEmpty()) {
            controller.nextRound();
        }
    }

    @Override
    public void doStage(BoardController b) {
        b.STAGE09();
    }

}
