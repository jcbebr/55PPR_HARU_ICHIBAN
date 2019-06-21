package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

public class Draw03GameStage extends GameStage {

    public Draw03GameStage(GameController controller) {
        super(controller);
        super.name = "Etapa 01 - Definição de jardineiros";
        super.info = "Jardineiro sênior, escolha a posição do sapo amarelo";
    }

    @Override
    public void nextStage() {
        controller.setStage(new GameStage03(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.drawGameStage03();
    }

}
