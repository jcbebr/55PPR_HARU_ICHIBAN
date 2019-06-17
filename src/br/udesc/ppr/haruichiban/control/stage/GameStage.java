package br.udesc.ppr.haruichiban.control.stage;

import br.udesc.ppr.haruichiban.control.observer.BoardController;
import br.udesc.ppr.haruichiban.control.observer.GameController;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 17/06/2019
 */
public abstract class GameStage {
    
    protected GameController controller;
    protected String name;
    protected String info;

    public GameStage(GameController controller) {
        this.controller = controller;
    }
    
    public abstract void nextStage();

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
    
    public abstract void doStage(BoardController b);
    
    
}
