package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

public class Draw02GameStage extends GameStage {

    public Draw02GameStage(GameController controller) {
        super(controller);
        super.name = "Etapa 01 - Definição de jardineiros";
        super.info = "Jardineiro sênior, escolha a posição do sapo vermelho";
    }

    @Override
    public void nextStage() {
        controller.setStage(new Draw03GameStage(controller));
    }

    @Override
    public void doStage(BoardController b) {
        b.drawGameStage02();
    }

}
