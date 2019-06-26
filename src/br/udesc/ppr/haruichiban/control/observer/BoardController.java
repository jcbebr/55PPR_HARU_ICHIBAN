package br.udesc.ppr.haruichiban.control.observer;

import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.control.builder.*;
import br.udesc.ppr.haruichiban.control.command.*;
import br.udesc.ppr.haruichiban.control.composite.ScoreController;
import br.udesc.ppr.haruichiban.control.strategy.MoveCardsDownStrategy;
import br.udesc.ppr.haruichiban.control.strategy.MoveCardsLeftStrategy;
import br.udesc.ppr.haruichiban.control.strategy.MoveCardsRightStrategy;
import br.udesc.ppr.haruichiban.control.strategy.MoveCardsStrategy;
import br.udesc.ppr.haruichiban.control.strategy.MoveCardsUpStrategy;
import br.udesc.ppr.haruichiban.control.visitor.CountNenupharVisitor;
import br.udesc.ppr.haruichiban.model.card.*;
import br.udesc.ppr.haruichiban.model.card.nenuphar.*;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class BoardController implements PanelTableController {

    //BUILDER
    private final Director director;
    private final Builder builder;
    private final Board board;
    //COMMAND
    private final BoardCommandInvoker commandInvoker;
    //OBSERVER
    private final List<PanelTableObserver> obss;
    //STRATEGY
    private MoveCardsStrategy strategy;

    public void setStrategy(MoveCardsStrategy strategy) {
        this.strategy = strategy;
    }

    public void move(int lastSelected) {
        this.strategy.move(rowSelected, columnSelected, lastSelected, board.getCards());
    }

    private int rowSelected;
    private int columnSelected;
    private int lastRowSelected;
    private int lastColumnSelected;

    private Card lastSelectedCard;

    public BoardController() {
        this.commandInvoker = new BoardCommandInvoker();
        this.obss = new ArrayList<>();
        this.builder = new EasyBuilder();
        this.director = new Director(builder);
        this.director.construir();
        this.board = builder.getBoard();
        this.rowSelected = 0;
        this.columnSelected = 0;
    }

    @Override
    public Card getValueAt(int row, int column, boolean selected) {
        return board.get(row, column);
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public void clickCell(int row, int column) {
        rowSelected = row;
        columnSelected = column;
        GameController.getInstance().doStage(this);
    }

    private boolean isEquals(Class c, Class... c1) {
        for (Class classes : c1) {
            if (c.equals(classes)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRoundWinner() {
        ScoreController sc = new ScoreController(board);
        int[] totalScore = sc.getTotalScore();
//        System.out.println(totalScore[0] + " - " + totalScore[1]);
        if (totalScore[0] != 0 || totalScore[1] != 0) {
            GameController.getInstance().getPointsController().addRedPoints(totalScore[0]);
            GameController.getInstance().getPointsController().addYellowPoints(totalScore[1]);
            if (GameController.getInstance().getPointsController().hasSingleWinner()) {
                GameController.getInstance().gameOver();
            } else {
                GameController.getInstance().nextRound();
            }
            return true;
        }
        return false;
    }

    public boolean checkBoard(int num) {
        CountNenupharVisitor v = new CountNenupharVisitor();
        try {
            board.accept(v);
        } catch (Exception ex) {
            System.out.println("Error [checkBoard] [BoardController]");
        }
        return v.getValue() <= num;
    }

    public void afterDraw() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.get(i, j).getClass().equals(BrightNenupharRedFrog.class)) {
                    board.setBrightNenupharRedFlower(i, j);
                } else if (board.get(i, j).getClass().equals(BrightNenupharYellowFrog.class)) {
                    board.setBrightNenupharYellowFlower(i, j);
                }
            }
        }
        hasRoundWinner();
    }

    public void drawGameStage02() {
        if (board.get(rowSelected, columnSelected).getClass().equals(BrightNenuphar.class)) {
            board.setRedFrog(rowSelected, columnSelected);
            GameController.getInstance().nextGameFlow();
        }
    }

    public void drawGameStage03() {
        if (board.get(rowSelected, columnSelected).getClass().equals(BrightNenuphar.class)) {
            board.setYellowFrog(rowSelected, columnSelected);
            GameController.getInstance().nextGameFlow();
        }
    }

    public void STAGE03() {
        if (board.get(rowSelected, columnSelected).getClass().equals(DarkNenuphar.class)) {
            if (GameController.getInstance().getSeniorGardener().equals(RedHandController.class)) {
                board.setDarkNenupharYellowFlower(rowSelected, columnSelected);
            } else {
                board.setDarkNenupharRedFlower(rowSelected, columnSelected);
            }
            if (!hasRoundWinner()) {
                GameController.getInstance().nextGameFlow();
            }
        }
    }

    public void STAGE04() {
        Class classe = board.get(rowSelected, columnSelected).getClass();
        if (classe.equals(DarkNenuphar.class)
                || classe.equals(BrightNenuphar.class)) {
            STAGE04MOVEMENT();
            GameController.getInstance().nextGameFlow();
        } else if (classe.equals(BrightNenupharRedFrog.class) || classe.equals(BrightNenupharYellowFrog.class)) {
            lastSelectedCard = board.get(rowSelected, columnSelected);
            STAGE04MOVEMENT();
        }
        hasRoundWinner();
    }

    private void STAGE04MOVEMENT() {
        if (GameController.getInstance().getSeniorGardener().equals(RedHandController.class)) {
            board.setBrightNenupharRedFlower(rowSelected, columnSelected);
        } else {
            board.setBrightNenupharYellowFlower(rowSelected, columnSelected);
        }
        GameController.getInstance().nextGameFlow();
    }

    public void STAGE05() {
        Class classe = board.get(rowSelected, columnSelected).getClass();
        if (classe.equals(BrightNenuphar.class)) {
            if (lastSelectedCard.getClass().equals(BrightNenupharRedFrog.class)) {
                board.setRedFrog(rowSelected, columnSelected);
            } else if (lastSelectedCard.getClass().equals(BrightNenupharYellowFrog.class)) {
                board.setYellowFrog(rowSelected, columnSelected);
            }
            if (!hasRoundWinner()) {
                GameController.getInstance().nextGameFlow();
            }
        }
    }

    public void STAGE06() {
        lastRowSelected = rowSelected;
        lastColumnSelected = columnSelected;

        if (!board.get(rowSelected, columnSelected).getClass().equals(Water.class)) {
            commandInvoker.add(new SearchWaterUpCommand(rowSelected, columnSelected, board.getCards()));
            commandInvoker.add(new SearchWaterDownCommand(rowSelected, columnSelected, board.getCards()));
            commandInvoker.add(new SearchWaterLeftCommand(rowSelected, columnSelected, board.getCards()));
            commandInvoker.add(new SearchWaterRightCommand(rowSelected, columnSelected, board.getCards()));
            commandInvoker.execute();

            GameController.getInstance().nextGameFlow();

            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }
    }

    public void STAGE07() {
        int lastSelected = 0;
        if (board.get(rowSelected, columnSelected).getClass().equals(SelectionIndicator.class)) {
            if (lastRowSelected == rowSelected) {
                if (columnSelected > lastColumnSelected) {
                    this.setStrategy(new MoveCardsRightStrategy());
                    lastSelected = lastColumnSelected;
                } else {
                    this.setStrategy(new MoveCardsLeftStrategy());
                    lastSelected = lastColumnSelected;
                }
            } else if (lastColumnSelected == columnSelected) {
                if (rowSelected > lastRowSelected) {
                    this.setStrategy(new MoveCardsDownStrategy());
                    lastSelected = lastRowSelected;
                } else {
                    this.setStrategy(new MoveCardsUpStrategy());
                    lastSelected = lastRowSelected;
                }
            }
            this.move(lastSelected);
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    if (board.get(i, j).getClass().equals(SelectionIndicator.class)) {
                        board.setWater(i, j);
                    }
                }
            }
            if (!hasRoundWinner()) {
                GameController.getInstance().nextGameFlow();
            }
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }

    }

    public void STAGE08() {
        Class classe = board.get(rowSelected, columnSelected).getClass();

        if (classe.equals(BrightNenuphar.class)) {
            board.setDarkNenuphar(rowSelected, columnSelected);
            GameController.getInstance().nextGameFlow();
            GameController.getInstance().nextGameFlow();
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        } else if (classe.equals(BrightNenupharRedFrog.class) || classe.equals(BrightNenupharYellowFrog.class)) {
            lastSelectedCard = board.get(rowSelected, columnSelected);
            board.setDarkNenuphar(rowSelected, columnSelected);
            GameController.getInstance().nextGameFlow();
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }
    }

    public void STAGE09() {
        if (board.get(rowSelected, columnSelected).getClass().equals(BrightNenuphar.class)) {
            if (lastSelectedCard.getClass().equals(BrightNenupharRedFrog.class)) {
                board.setRedFrog(rowSelected, columnSelected);
            } else if (lastSelectedCard.getClass().equals(BrightNenupharYellowFrog.class)) {
                board.setYellowFrog(rowSelected, columnSelected);
            }
            if (!hasRoundWinner()) {
                GameController.getInstance().nextGameFlow();
            }
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }
    }

    @Override
    public void addObservador(PanelTableObserver obs) {
        this.obss.add(obs);
    }

    @Override
    public void removerObservador(PanelTableObserver obs) {
        this.obss.remove(obs);
    }

    public void nextRound() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (isEquals(board.get(i, j).getClass(),
                        BrightNenupharRedFlower.class,
                        BrightNenupharYellowFlower.class)) {
                    board.setBrightNenuphar(i, j);
                }
                if (isEquals(board.get(i, j).getClass(),
                        BrightNenuphar.class,
                        BrightNenupharRedFrog.class,
                        BrightNenupharYellowFrog.class,
                        DarkNenuphar.class,
                        DarkNenupharRedFlower.class,
                        DarkNenupharYellowFlower.class)) {
                    if (((Nenuphar) board.get(i, j)).getName().equals(BrightNenupharRedFrog.class)) {
                        board.setRedFrog(i, j);
                    } else if (((Nenuphar) board.get(i, j)).getName().equals(BrightNenupharYellowFrog.class)) {
                        board.setYellowFrog(i, j);
                    } else if (((Nenuphar) board.get(i, j)).getName().equals(DarkNenuphar.class)) {
                        board.setDarkNenuphar(i, j);
                    } else {
                        board.setBrightNenuphar(i, j);
                    }
                }
                /*if (board.get(i, j).getClass().equals(DarkNenupharRedFlower.class)
                || board.get(i, j).getClass().equals(DarkNenupharYellowFlower.class)
                || board.get(i, j).getClass().equals(DarkNenuphar.class)) {
                boolean f = ((DarkNenuphar) board.get(i, j)).isFather();
                if (f) {
                board.setDarkNenuphar(i, j, true);
                } else {
                board.setBrightNenuphar(i, j);
                }
                }*/
            }
        }
    }
}
