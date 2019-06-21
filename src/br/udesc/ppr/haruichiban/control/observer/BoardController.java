package br.udesc.ppr.haruichiban.control.observer;

import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.control.builder.*;
import br.udesc.ppr.haruichiban.control.command.*;
import br.udesc.ppr.haruichiban.model.card.*;
import br.udesc.ppr.haruichiban.model.card.nenuphar.*;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class BoardController implements PanelTableController {

    private final Director director;
    private final Builder builder;
    private final Board board;

    private final BoardCommandInvoker commandInvoker;
    private final List<PanelTableObserver> obss;

    private int rowSelected;
    private int columnSelected;
    private int lastRowSelected;
    private int lastColumnSelected;

    private Card lastSelectedCard;

    public BoardController() {
        this.commandInvoker = new BoardCommandInvoker();
        this.obss = new ArrayList<>();
        this.builder = new TestBuilder();
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

    private boolean c1(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2);
    }

    private boolean c21(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i, j + 3).getClass(), c1, c2);
    }

    private boolean c22(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j).getClass(), c1, c2);
    }

    private boolean c31(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j + 3).getClass(), c1, c2);
    }

    private boolean c32(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j - 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j - 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j - 3).getClass(), c1, c2);
    }

    private boolean c41(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j).getClass(), c1, c2);
    }

    private boolean c42(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i, j + 3).getClass(), c1, c2)
                && isEquals(board.get(i, j + 4).getClass(), c1, c2);
    }

    private boolean c43(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j + 3).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j + 4).getClass(), c1, c2);
    }

    private boolean c44(int i, int j, Class c1, Class c2) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j - 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j - 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j - 3).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j - 4).getClass(), c1, c2);
    }

    private boolean isEquals(Class c, Class... c1) {
        for (Class classes : c1) {
            if (c.equals(classes)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEquals(Class c, Class c1, Class c2) {
        return c.equals(c1) || c.equals(c2);
    }

    private boolean hasRoundWinner() {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize() - 1; i++) {
            for (int j = 0; j < board.getSize() - 1; j++) {
                if (c1(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                    r++;
                }
                if (c1(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                    y++;
                }
            }
        }
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (c22(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                    r += 2;
                }
                if (c22(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                    y += 2;
                }
            }
        }
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 3; j++) {
                if (c21(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                    r += 2;
                }
                if (c21(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                    y += 2;
                }
            }
        }
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 0; j < board.getSize() - 3; j++) {
                System.out.println("i " + i + " j " + j);
                if (c31(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                    r += 3;
                }
                if (c31(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                    y += 3;
                }
            }
        }
        System.out.println("-");
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 3; j < board.getSize(); j++) {
                System.out.println("i " + i + " j " + j);
                if (c32(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                    r += 3;
                }
                if (c32(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                    y += 3;
                }
            }
        }
        for (int j = 0; j < board.getSize(); j++) {
            if (c41(0, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                r += 5;
            }
            if (c41(0, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                y += 5;
            }
        }
        for (int i = 0; i < board.getSize(); i++) {
            if (c42(i, 0, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
                r += 5;
            }
            if (c42(i, 0, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
                y += 5;
            }
        }
        if (c43(0, 0, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
            r += 5;
        }
        if (c43(0, 0, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
            y += 5;
        }
        if (c44(0, 4, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class)) {
            r += 5;
        }
        if (c44(0, 4, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class)) {
            y += 5;
        }

        if (r != 0 || y != 0) {
            GameController.getInstance().getPointsController().addRedPoints(r);
            GameController.getInstance().getPointsController().addYellowPoints(y);
            if (GameController.getInstance().getPointsController().hasSingleWinner()) {
                GameController.getInstance().gameOver();
            }
            GameController.getInstance().nextRound();
            return true;
        }
        return false;
    }

    public boolean checkNFlowers() {
        int n = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (isEquals(board.get(i, j).getClass(), BrightNenuphar.class, DarkNenuphar.class)) {
                    n++;
                }
            }
        }
        return n <= 2;
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
        if (board.get(rowSelected, columnSelected).getClass().equals(SelectionIndicator.class)) {
            if (lastRowSelected == rowSelected) {
                if (columnSelected > lastColumnSelected) {
                    commandInvoker.add(new MoveCardsRightCommand(rowSelected, columnSelected, lastColumnSelected, board.getCards()));
                } else {
                    commandInvoker.add(new MoveCardsLeftCommand(rowSelected, columnSelected, lastColumnSelected, board.getCards()));
                }
            } else if (lastColumnSelected == columnSelected) {
                if (rowSelected > lastRowSelected) {
                    commandInvoker.add(new MoveCardsDownCommand(rowSelected, columnSelected, lastRowSelected, board.getCards()));
                } else {
                    commandInvoker.add(new MoveCardsUpCommand(rowSelected, columnSelected, lastRowSelected, board.getCards()));
                }
            }
            commandInvoker.execute();
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
