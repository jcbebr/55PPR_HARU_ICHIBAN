package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public class GameStage01 extends GameStage {

    public GameStage01(GameController controller) {
        super(controller);
        super.name = "Etapa 01 - Definição de jardineiros";
        super.info = "Jogador amarelo, escolha a carta";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage02(controller));
    }

    @Override
    public void doStage(BoardController b) {

    }

}
