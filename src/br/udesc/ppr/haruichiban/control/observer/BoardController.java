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

    private int lastRowSelected;
    private int lastColumnSelected;

    public BoardController() {
        this.commandInvoker = new BoardCommandInvoker();
        this.obss = new ArrayList<>();
        this.builder = new EasyBuilder();
        this.director = new Director(builder);
        director.construir();
        this.board = builder.getBoard();
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
        switch (GameController.getInstance().getGameFlow()) {
            case STAGE03:
                STAGE03(row, column);
                break;
            case STAGE04:
                STAGE04(row, column);
                break;
            case STAGE05:
                STAGE05(row, column);
                break;
            case STAGE06:
                STAGE06(row, column);
                break;
            case STAGE07:
                STAGE07(row, column);
                break;
            case STAGE08:
                STAGE08(row, column);
                break;
            case STAGE09:
                STAGE09(row, column);
                break;
            default:
                break;
        }
    }

    private Card lastSelectedCard;

    private void STAGE03(int row, int column) {
        if (board.get(row, column).getClass().equals(DarkNenuphar.class)) {
            if (GameController.getInstance().getSeniorGardener().equals(RedHandController.class)) {
                board.setDarkNenupharYellowFlower(row, column);
            } else {
                board.setDarkNenupharRedFlower(row, column);
            }
            GameController.getInstance().nextGameFlow();
        }
    }

    private void STAGE04(int row, int column) {
        Class classe = board.get(row, column).getClass();
        if (classe.equals(DarkNenuphar.class)
                || classe.equals(BrightNenuphar.class)) {
            STAGE04MOVEMENT(row, column);
            GameController.getInstance().nextGameFlow();
        } else if (classe.equals(BrightNenupharRedFrog.class) || classe.equals(BrightNenupharYellowFrog.class)) {
            lastSelectedCard = board.get(row, column);
            STAGE04MOVEMENT(row, column);
        }
    }

    private void STAGE04MOVEMENT(int row, int column) {
        if (GameController.getInstance().getSeniorGardener().equals(RedHandController.class)) {
            board.setBrightNenupharRedFlower(row, column);
        } else {
            board.setBrightNenupharYellowFlower(row, column);
        }
        GameController.getInstance().nextGameFlow();
    }

    private void STAGE05(int row, int column) {
        Class classe = board.get(row, column).getClass();
        if (classe.equals(BrightNenuphar.class)) {
            if (lastSelectedCard.getClass().equals(BrightNenupharRedFrog.class)) {
                board.setRedFrog(row, column);
            } else if (lastSelectedCard.getClass().equals(BrightNenupharYellowFrog.class)) {
                board.setYellowFrog(row, column);
            }
            GameController.getInstance().nextGameFlow();
        }
    }

    private void STAGE06(int row, int column) {
        lastRowSelected = row;
        lastColumnSelected = column;

        if (!board.get(row, column).getClass().equals(Water.class)) {
            commandInvoker.add(new SearchWaterUpCommand(row, column, board.getCards()));
            commandInvoker.add(new SearchWaterDownCommand(row, column, board.getCards()));
            commandInvoker.add(new SearchWaterLeftCommand(row, column, board.getCards()));
            commandInvoker.add(new SearchWaterRightCommand(row, column, board.getCards()));
            commandInvoker.execute();

            GameController.getInstance().nextGameFlow();

            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }
    }

    private void STAGE07(int row, int column) {
        if (board.get(row, column).getClass().equals(SelectionIndicator.class)) {
            if (lastRowSelected == row) {
                if (column > lastColumnSelected) {
                    commandInvoker.add(new MoveCardsRightCommand(row, column, lastColumnSelected, board.getCards()));
                } else {
                    commandInvoker.add(new MoveCardsLeftCommand(row, column, lastColumnSelected, board.getCards()));
                }
            } else if (lastColumnSelected == column) {
                if (row > lastRowSelected) {
                    commandInvoker.add(new MoveCardsDownCommand(row, column, lastRowSelected, board.getCards()));
                } else {
                    commandInvoker.add(new MoveCardsUpCommand(row, column, lastRowSelected, board.getCards()));
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
            GameController.getInstance().nextGameFlow();
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }

    }

    private void STAGE08(int row, int column) {
        Class classe = board.get(row, column).getClass();

        if (classe.equals(BrightNenuphar.class)) {
            board.setDarkNenuphar(row, column);
            GameController.getInstance().nextGameFlow();
            GameController.getInstance().nextGameFlow();
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        } else if (classe.equals(BrightNenupharRedFrog.class) || classe.equals(BrightNenupharYellowFrog.class)) {
            lastSelectedCard = board.get(row, column);
            board.setDarkNenuphar(row, column);
            GameController.getInstance().nextGameFlow();
            for (PanelTableObserver obs : obss) {
                obs.notifyChangedCards();
            }
        }
    }

    private void STAGE09(int row, int column) {
        if (board.get(row, column).getClass().equals(BrightNenuphar.class)) {
            if (lastSelectedCard.getClass().equals(BrightNenupharRedFrog.class)) {
                board.setRedFrog(row, column);
            } else if (lastSelectedCard.getClass().equals(BrightNenupharYellowFrog.class)) {
                board.setYellowFrog(row, column);
            }
            GameController.getInstance().nextGameFlow();
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
}
