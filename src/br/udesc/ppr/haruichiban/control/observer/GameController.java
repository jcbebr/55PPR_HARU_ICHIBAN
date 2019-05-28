package br.udesc.ppr.haruichiban.control.observer;

import br.udesc.ppr.haruichiban.model.GameFlow;
import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.model.Gardeners;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class GameController implements Observed {

    private static GameController instance;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    
    public void kill(){
        instance = null;
    }

    private GameFlow gameFlow;
    private final List<Observer> obss;

    private final RedHandController redHandController;
    private final YellowHandController yellowHandController;
    private final BoardController boardController;

    public GameController() {
        this.gameFlow = GameFlow.STAGE01;
        this.obss = new ArrayList();
        this.redHandController = new RedHandController();
        this.yellowHandController = new YellowHandController();
        this.boardController = new BoardController();
    }

    public GameFlow getGameFlow() {
        return gameFlow;
    }

    public void nextGameFlow() {
        boolean draw = false;
        switch (gameFlow) {
            case STAGE01:
                gameFlow = GameFlow.STAGE02;
                break;
            case STAGE02:
                try {
                    if (redHandController.getSelectedCardValue() > yellowHandController.getSelectedCardValue()) {
                        redHandController.setGardener(Gardeners.SENIOR);
                        yellowHandController.setGardener(Gardeners.JUNIOR);
                    } else if (redHandController.getSelectedCardValue() < yellowHandController.getSelectedCardValue()) {
                        redHandController.setGardener(Gardeners.JUNIOR);
                        yellowHandController.setGardener(Gardeners.SENIOR);
                    } else {
                        draw = true;
                    }
                    if (draw) {
                        gameFlow = GameFlow.STAGE01;
                        redHandController.reserveSelectedCard();
                        yellowHandController.reserveSelectedCard();
                    } else {
                        gameFlow = GameFlow.STAGE03;
                        redHandController.removeSelectedCard();
                        yellowHandController.removeSelectedCard();
                    }
                } catch (IndexOutOfBoundsException e) {
                    for (Observer obs : obss) {
                        ((MainScreenObserver) obs).notifyEmptyDesck(e.getMessage());
                    }
                }
                break;
            case STAGE03:
                gameFlow = GameFlow.STAGE04;
                break;
            case STAGE04:
                gameFlow = GameFlow.STAGE05;
                break;
            case STAGE05:
                gameFlow = GameFlow.STAGE06;
                break;
            case STAGE06:
                gameFlow = GameFlow.STAGE07;
                break;
            case STAGE07:
                gameFlow = GameFlow.STAGE08;
                break;
            case STAGE08:
                gameFlow = GameFlow.STAGE09;
                break;
            case STAGE09:
                redHandController.removeGardener();
                yellowHandController.removeGardener();
                gameFlow = GameFlow.STAGE01;
                break;
            default:
                break;
        }
        String infoRound = gameFlow.getInfo();
        if (draw) {
            infoRound = "Empate - " + infoRound + " novamente";
        }
        for (Observer obs : obss) {
            ((MainScreenObserver) obs).notifyNextRound(gameFlow.getName(), infoRound);
        }
    }

    public RedHandController getRedHandController() {
        return redHandController;
    }

    public YellowHandController getYellowHandController() {
        return yellowHandController;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public Class getSeniorGardener() {
        if (redHandController.getGardener().equals(Gardeners.SENIOR)) {
            return redHandController.getClass();
        } else {
            return yellowHandController.getClass();
        }
    }

    @Override
    public void addObservador(Observer obs) {
        this.obss.add(obs);
    }

    @Override
    public void removerObservador(Observer obs) {
        this.obss.remove(obs);
    }

}
