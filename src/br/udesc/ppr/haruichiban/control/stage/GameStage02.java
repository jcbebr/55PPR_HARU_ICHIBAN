package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;
import br.udesc.ppr.haruichiban.control.observer.MainScreenObserver;
import br.udesc.ppr.haruichiban.control.observer.Observer;
import br.udesc.ppr.haruichiban.model.Gardeners;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage02 extends GameStage {

    public GameStage02(GameController controller) {
        super(controller);
        super.name = "Etapa 01 - Definição de jardineiros";
        super.info = "Jogador vermelho, escolha a carta";
    }

    @Override
    public void nextStage() {
        boolean draw = false;
        try {
            if (controller.getRedHandController().getSelectedCardValue()
                    > controller.getYellowHandController().getSelectedCardValue()) {
                controller.getRedHandController().setGardener(Gardeners.SENIOR);
                controller.getYellowHandController().setGardener(Gardeners.JUNIOR);
            } else if (controller.getRedHandController().getSelectedCardValue() < controller.getYellowHandController().getSelectedCardValue()) {
                controller.getRedHandController().setGardener(Gardeners.JUNIOR);
                controller.getYellowHandController().setGardener(Gardeners.SENIOR);
            } else {
                draw = true;
            }
            if (draw) {
                Draw01GameStage stage = new Draw01GameStage(controller);
                controller.setStage(stage);
                controller.getBoardController().afterDraw();
            } else {
                controller.setStage(new GameStage03(controller));
            }
            controller.getRedHandController().removeSelectedCard();
            controller.getYellowHandController().removeSelectedCard();
        } catch (IndexOutOfBoundsException e) {
            for (Observer obs : controller.getObss()) {
                ((MainScreenObserver) obs).notifyEmptyDesck(e.getMessage());
            }
        }
    }

    @Override
    public void doStage(BoardController b) {
    }

}
