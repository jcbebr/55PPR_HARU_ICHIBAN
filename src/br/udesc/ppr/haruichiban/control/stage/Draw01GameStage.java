
package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;


public class Draw01GameStage extends GameStage {

    public Draw01GameStage(GameController controller) {
        super(controller);
        super.name = "Etapa 01 - Definição de jardineiros";
        super.info = "Houve empate, aperte o botão coaxar!";
    }

    @Override
    public void nextStage() {
        controller.setStage(new Draw02GameStage(controller));
    }

    @Override
    public void doStage(BoardController b) {
        
    }

}
