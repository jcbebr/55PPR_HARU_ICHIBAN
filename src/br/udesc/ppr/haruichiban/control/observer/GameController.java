package br.udesc.ppr.haruichiban.control.observer;

import br.udesc.ppr.haruichiban.control.stage.GameOverStage;
import br.udesc.ppr.haruichiban.control.stage.GameStage;
import br.udesc.ppr.haruichiban.control.stage.GameStage01;
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

    public void kill() {
        instance = null;
    }

    private GameStage stage;
    private final List<Observer> obss;

    private RedHandController redHandController;
    private YellowHandController yellowHandController;
    private BoardController boardController;
    private PointsController pointsController;
    private String drawWinner;

    private GameController() {
        this.stage = new GameStage01(this);
        this.obss = new ArrayList();
        this.redHandController = new RedHandController();
        this.yellowHandController = new YellowHandController();
        this.boardController = new BoardController();
        this.pointsController = new PointsController();
    }

    public void setStage(GameStage stage) {
        this.stage = stage;
    }

    public GameStage getStage() {
        return stage;
    }

    public void doStage(BoardController b) {
        stage.doStage(b);
    }

    public void nextGameFlow() {
        stage.nextStage();
        System.out.println(stage.getClass().toString());
        String infoRound = stage.getInfo();
        for (Observer obs : obss) {
            ((MainScreenObserver) obs).notifyNextRoundStep(stage.getName(), infoRound);
        }
    }

    public PointsController getPointsController() {
        return pointsController;
    }

    public List<Observer> getObss() {
        return obss;
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

    public void nextRound() {
        setStage(new GameStage01(this));
        redHandController.resetDeck();
        redHandController.removeGardener();
        yellowHandController.resetDeck();
        yellowHandController.removeGardener();
        unselectCards();
        boardController.nextRound();
        for (Observer obs : obss) {
            ((MainScreenObserver) obs).notifyNextRoundStep(stage.getName(), stage.getInfo());
        }
        for (Observer obs : obss) {
            ((MainScreenObserver) obs).notifyNextRound("");
        }
    }
    
    public void unselectCards(){
        redHandController.unselectCard();
        yellowHandController.unselectCard();
    }

    public void gameOver() {
        setStage(new GameOverStage(this));
        for (Observer obs : obss) {
            ((MainScreenObserver) obs).notifyGameOver("Fim do jogo, parabéns jogador " + pointsController.getWinner());
        }
    }

    public void setDrawWinner(String drawWinner) {
        this.drawWinner = drawWinner;
        if (drawWinner.equals("Vermelho")) {
            redHandController.setGardener(Gardeners.SENIOR);
            yellowHandController.setGardener(Gardeners.JUNIOR);
        } else {
            redHandController.setGardener(Gardeners.JUNIOR);
            yellowHandController.setGardener(Gardeners.SENIOR);
        }
        if (boardController.checkBoard(2)) {
            nextGameFlow();
            nextGameFlow();
        }
        nextGameFlow();
    }

}
